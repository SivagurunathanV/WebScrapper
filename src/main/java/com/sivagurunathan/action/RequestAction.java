package com.sivagurunathan.action;

import com.sivagurunathan.dto.Request;
import com.sivagurunathan.dto.ResponsePayload;
import com.sivagurunathan.dto.ScrappingRequest;
import com.sivagurunathan.repositories.RequestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

/**
 * Created by sivagurunathan.v on 20/05/17.
 */
@Service
public class RequestAction implements Action<ResponsePayload> {

    @Autowired
    private RequestRepository requestRepository;

    private Request request;

    public RequestAction withRequest(Request request){
        this.request = request;
        return this;
    }

    @Override
    public ResponsePayload invoke() {

        ScrappingRequest scrappingRequest = new ScrappingRequest();
        scrappingRequest.setEmailId(request.getEmailId());
        scrappingRequest.setUrl(request.getUrl());
//        scrappingRequest.setSendNotification(true);
        this.requestRepository.save(scrappingRequest);
        ResponsePayload responsePayload = new ResponsePayload();
        responsePayload.setValue((int) scrappingRequest.getId());
        return responsePayload;
    }
}
