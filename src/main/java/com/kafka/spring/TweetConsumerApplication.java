package com.kafka.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.util.FileCopyUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan
@ComponentScan("com.kafka.spring")
public class TweetConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TweetConsumerApplication.class, args);




        Process process = null;
        try {
            process = new ProcessBuilder()
                    .command("/Users/iGD-Dev1/Downloads/kafka_2.12-3.3.1/bin/kafka-consumer-groups.sh", "--bootstrap-server", "localhost:9092",
                            "--describe", "--group", "tweet-group")
                    .start();


            InputStream inputStream = process.getInputStream();
            try {
                process.waitFor(60, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            FileCopyUtils.copy(inputStream, baos);
            System.out.println("LAG: " + new String(baos.toByteArray()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
