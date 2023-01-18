//package com.kafka.spring;
//
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//
//@Service
//public class TweetConsumerService {
//
//    private TweetConsumerRepository tweetConsumerRepository;
//
//    public TweetConsumerService(TweetConsumerRepository tweetConsumerRepository) {
//        this.tweetConsumerRepository = tweetConsumerRepository;
//    }
//
//    @KafkaListener(topics = { "tweet-topic" })
//    public void consumerTwitterData(Tweet[] tweets) {
//        for(Tweet tweet: tweets) {
//
//            tweetConsumerRepository.save(tweet);
//            System.out.println("Tweet " + tweet.getRaw());
//        }
//
//    }
//}
