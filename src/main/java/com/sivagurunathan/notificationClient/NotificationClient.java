package com.sivagurunathan.notificationClient;

import com.sivagurunathan.dto.ScrappingRequest;

/**
 * Created by sivagurunathan.v on 22/05/17.
 */
public interface NotificationClient {
    void sendNotification(String contact, String content);
}
