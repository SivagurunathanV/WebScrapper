package com.sivagurunathan.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import lombok.Data;

/**
 * Created by sivagurunathan.v on 21/05/17.
 */
@Service
@Data
public class AmazonWebScrapper implements WebScrapper {

    private Document doc;

    @Override
    public Future<Document> readURL(String url) {

        String fileContents;
        String currentLine = "";
        Document response = null;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
            fileContents = reader.readLine();
            while (currentLine != null) {
                currentLine = reader.readLine();
                fileContents += "\n" + currentLine;
            }
            response = Jsoup.parse(fileContents);
        } catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return new AsyncResult<Document>(response);
    }

    public Future<Long> getPrice(String url){
        Future<Document> document = readURL(url);
        try {
            while(!document.isDone()){
                Thread.sleep(100);
            }
            doc = document.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Elements element = doc.select("span#priceblock_ourprice");
        Long price = element != null ? Double.valueOf(element.text().
            replaceAll("\u00A0","").replaceAll(",","")).longValue():0L;
        return new AsyncResult<Long>(price);
    }

    public String getAvailability(String url){
        Future<Document> document = readURL(url);
        try {
            while(!document.isDone()){
                Thread.sleep(100);
            }
            doc = document.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Elements element = doc.select("div#availability");
        return element != null ? element.text().replaceAll("\u00A0","") : null;
    }


}
