package com.sivagurunathan.dto;

import lombok.Data;

/**
 * Created by sivagurunathan.v on 21/05/17.
 */
@Data
public class CronRequest {

    private String url;

    private boolean sendNotification;

}
