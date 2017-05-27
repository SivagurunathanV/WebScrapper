package com.sivagurunathan.config;

import com.sivagurunathan.dto.ScrappingRequest;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by sivagurunathan.v on 20/05/17.
 */
//@Configuration
//@EnableTransactionManagement
public class AppConfig {
//
//    @Bean
//    public HibernateTemplate getHibernateTemplate(){
//        return new HibernateTemplate(getSessionFactory());
//    }
//
//    @Bean
//    public SessionFactory getSessionFactory() {
//        return new LocalSessionFactoryBuilder(getDataSource())
//            .addAnnotatedClass(ScrappingRequest.class)
//            .buildSessionFactory();
//    }
////
//    @Bean
//    public DataSource getDataSource() {
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/Spring");
//        dataSource.setUsername("root");
//        dataSource.setPassword("");
//        return dataSource;
//    }
//
//    @Bean
//    public HibernateTransactionManager hibernateSessionManager(){
//        return new HibernateTransactionManager(getSessionFactory());
//    }

}
