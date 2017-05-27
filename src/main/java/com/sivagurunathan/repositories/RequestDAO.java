package com.sivagurunathan.repositories;



import com.sivagurunathan.dto.Request;
import com.sivagurunathan.dto.ScrappingRequest;

//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import lombok.Data;


/**
 * Created by sivagurunathan.v on 20/05/17.
 */
@Data
@Component
public class RequestDAO {

//    @Autowired
//    private JdbcTemplate jdbcTemplate;

//    @Autowired
//    private HibernateTemplate hibernateTemplate;


//    @Override
//    public int insert(Request request) {
////        StringBuilder insertQuery = new StringBuilder();
////        insertQuery.append("INSERT INTO requests (`url`, `email_id`) values ('");
////        insertQuery.append(request.getUrl() + "','");
////        insertQuery.append(request.getEmailId());
////        insertQuery.append("')");
////        System.out.println(insertQuery.toString());
//
//        ScrappingRequest scrappingRequest = new ScrappingRequest();
//        scrappingRequest.setEmailId(request.getEmailId());
//        scrappingRequest.setUrl(request.getUrl());
//
//        return 0;
//    }
//
//    @Override
//    public int delete(Long id) {
//        return 0;
//    }
//
//    @Override
//    public ScrappingRequest selectRequestById(Long id) {
//        return null;
//    }
//
//    @Override
//    public ScrappingRequest selectRequestByEmail(String field) {
//        return null;
//    }

}
