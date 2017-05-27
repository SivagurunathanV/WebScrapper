package com.sivagurunathan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
/**
 * Created by sivagurunathan.v on 19/05/17.
 */
@SpringBootApplication
@EnableAsync
@EnableJpaRepositories("com.sivagurunathan.repositories")
@EnableScheduling
public class Application extends AsyncConfigurerSupport{

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor threadPoolExecutor = new ThreadPoolTaskExecutor();
        threadPoolExecutor.setCorePoolSize(2);
        threadPoolExecutor.setMaxPoolSize(2);
        threadPoolExecutor.setQueueCapacity(500);
        threadPoolExecutor.setKeepAliveSeconds(1000);
        threadPoolExecutor.setThreadNamePrefix("CronJob");
        threadPoolExecutor.initialize();
        return threadPoolExecutor;
    }
}
