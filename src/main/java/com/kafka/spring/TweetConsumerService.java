package com.kafka.spring;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class TweetConsumerService {

    @KafkaListener(topics = { "tweet-topic" })
    public void consumerTwitterData(Tweet[] tweets) {
        for(Tweet tweet: tweets) {
            System.out.println("Tweet " + tweet.getRaw());
        }

    }
}
