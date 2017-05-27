package com.sivagurunathan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by sivagurunathan.v on 20/05/17.
 */
//@Configuration
//@EnableTransactionManagement
public class JDBCDriverConfig {

    @Value("${database.driver}")
    private String driver;

    @Value("${database.url}")
    private String url;

    @Value("${database.username}")
    private String username;

    @Value("${database.password}")
    private String password;

//
//    @Bean
//    @Autowired
//    public DataSource provideDataSource() throws ClassNotFoundException {
//        SimpleDriverDataSource mysqlDataStore = new SimpleDriverDataSource();
//        Class mysqlDriver = Class.forName(driver);
//        mysqlDataStore.setDriverClass(mysqlDriver);
//        mysqlDataStore.setUrl(url);
//        mysqlDataStore.setUsername(username);
//        mysqlDataStore.setPassword(password);
//        return mysqlDataStore;
//    }



}
