package com.kafka.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableJpaRepositories
@EntityScan
@ComponentScan("com.kafka.spring")
@EnableScheduling
public class TweetConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TweetConsumerApplication.class, args);





    }


}
