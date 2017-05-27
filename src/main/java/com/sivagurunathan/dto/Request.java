package com.sivagurunathan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.Data;

/**
 * Created by sivagurunathan.v on 20/05/17.
 */
@Data
public class Request {

    @JsonProperty("email_id")
    private String emailId;

    private String url;

}
