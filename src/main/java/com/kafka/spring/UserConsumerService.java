package com.kafka.spring;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserConsumerService {

    @KafkaListener(topics = { "user-topic" })
    public void consumerUserData(Tweet[] tweets) {
        for(Tweet tweet: tweets) {
            System.out.println("Tweet " + tweet.getRawTweets());
        }
        //
        //System.out.println("Users Age Is: " + user.getAge()+" Fav Genre "+user.getFavGenre());
    }
}
