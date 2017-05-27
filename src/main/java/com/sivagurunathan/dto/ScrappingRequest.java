package com.sivagurunathan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.annotations.Type;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;

/**
 * Created by sivagurunathan.v on 19/05/17.
 */
@Data
@Entity
@Table(name = "requests")
@Repository
public class ScrappingRequest {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String emailId;

    @Lob
    private String url;

    @Column(name = "send_notification", columnDefinition = "boolean default false")
    private boolean sendNotification;

    @Column(name = "price", columnDefinition = "Decimal(10,2) default '0.00'")
    private long price;
}
