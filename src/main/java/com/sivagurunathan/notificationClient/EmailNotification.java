package com.sivagurunathan.notificationClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by sivagurunathan.v on 22/05/17.
 */
@Data
@Slf4j
@Service
public class EmailNotification implements NotificationClient {

    @Autowired
    private JavaMailSender mailSender;


    @Override
    public void sendNotification(String emailId, String content) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(emailId);
        simpleMailMessage.setText(content);
        simpleMailMessage.setFrom("mail.domain.com");
        simpleMailMessage.setSubject("PRICE DROPPED");
        mailSender.send(simpleMailMessage);
    }
}
