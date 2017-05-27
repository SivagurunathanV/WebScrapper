package com.sivagurunathan.parser;

import org.jsoup.nodes.Document;

import java.util.concurrent.Future;

/**
 * Created by sivagurunathan.v on 21/05/17.
 */
public interface WebScrapper {

    /**
     * READ URL AND RETURNS THE HTML OBJECT AS STRING
     * */
    Future<Document> readURL(String url);

    /**
     * Read URL AND RETURN THE PRICE OF PRODUCT
     * **/
    Future<Long> getPrice(String url);



    /**
     * READ URL AND RETURNS THE AVAILABILITY OF THE PRODUCT EITHER AS IN STOCK OR OUT OF STOCK
     * **/
    String getAvailability(String url);

}
