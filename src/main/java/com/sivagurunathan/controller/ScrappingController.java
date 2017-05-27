package com.sivagurunathan.controller;



import com.sivagurunathan.parser.WebScrapper;
import com.sivagurunathan.action.RequestAction;
import com.sivagurunathan.action.UpdatePriceAction;
import com.sivagurunathan.action.UpdatePriceByBulkAction;
import com.sivagurunathan.dto.CronRequest;
import com.sivagurunathan.dto.Request;
import com.sivagurunathan.dto.ResponsePayload;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


/**
 * Created by sivagurunathan.v on 19/05/17.
 */
@RestController
public class ScrappingController {

    @Autowired
    private RequestAction requestAction;

    @Autowired
    private WebScrapper webScrapper;

    @Autowired
    private UpdatePriceAction updatePriceAction;

    @Autowired
    private UpdatePriceByBulkAction updatePriceByBulkAction;

    @RequestMapping(value = "/scrap", method = RequestMethod.POST)
    public ResponseEntity<?> scrap(@RequestBody Request request){
        // TODO: 21/05/17 move this validation to RequestAction class with Null check in Request
        if(StringUtils.isNotBlank(request.getUrl())
            && StringUtils.isNotBlank(request.getEmailId())){
           ResponsePayload responsePayload = requestAction.withRequest(request)
               .invoke();
            return ResponseEntity.ok(responsePayload);
        }
        else{
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }



    @RequestMapping(value = "/amazon_scrap_price", method = RequestMethod.POST)
    public ResponseEntity<?> getPriceFromAmazon(@RequestBody CronRequest request)
        throws InterruptedException, ExecutionException {
        if(request.isSendNotification()){
            Future<Long> price = webScrapper.getPrice(request.getUrl());
            while(price.isDone()){
                Thread.sleep(100);
            }
            return updatePriceAction.withScrappingRequest(request)
                .withPrice(price.get())
                .invoke();
        }
        else{
            return ResponseEntity.ok("Nothing Done");
        }
    }

    @RequestMapping(value = "/amazon_scrap_available", method = RequestMethod.GET)
    public ResponseEntity<?> getAvailabilityFromAmazon(@RequestParam(value = "url") String url){
        String availability = webScrapper.getAvailability(url);
        return ResponseEntity.ok(availability);
    }

    @RequestMapping(value = "/amazon_scrap_bulk", method = RequestMethod.POST)
    @Async
    @Scheduled(cron = "0 0/2 * * * *")
    public ResponseEntity<?> getPriceFromAmazonBulk(){
        return ResponseEntity.ok(updatePriceByBulkAction.invoke());
    }

}
