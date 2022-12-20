package com.kafka.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan
@ComponentScan("com.kafka.spring")
public class TweetConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TweetConsumerApplication.class, args);
    }

}
