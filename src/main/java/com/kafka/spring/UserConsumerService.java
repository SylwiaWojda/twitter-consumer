package com.kafka.spring;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

@Service
public class UserConsumerService {

    @KafkaListener(topics = { "tweet-topic" })
    public void consumerUserData(Tweet[] tweets) {
        for(Tweet tweet: tweets) {
            System.out.println("Tweet " + tweet.getRaw());
        }

        Process process = null;
        try {
            process = new ProcessBuilder()
                    .command("/Users/iGD-Dev1/Downloads/kafka_2.12-3.3.1/bin/kafka-consumer-groups.sh", "--bootstrap-server", "localhost:9092",
                            "--describe", "--group", "tweet-group")
                    .start();


            InputStream inputStream = process.getInputStream();
            try {
                process.waitFor(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            FileCopyUtils.copy(inputStream, baos);
            System.out.println("LAG: " + new String(baos.toByteArray()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //
        //System.out.println("Users Age Is: " + user.getAge()+" Fav Genre "+user.getFavGenre());
    }
}
