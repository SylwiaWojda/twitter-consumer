package com.kafka.spring;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TweetConsumerService {

    private ConsumedTweetRepository tweetConsumerRepository;

    public TweetConsumerService(ConsumedTweetRepository tweetConsumerRepository) {
        this.tweetConsumerRepository = tweetConsumerRepository;
    }

    @KafkaListener(topics = { "tweet-topic" })
    public void consumerTwitterData(List<Tweet> tweets) {
        System.out.println("Amount of consumed tweets: " + tweets.size());
        for(Tweet tweet: tweets) {

            Consumed consumedTweet = new Consumed();
            consumedTweet.setRaw(tweet.getRaw());
//            consumedTweet.setRawTweets("0");
            consumedTweet.setAmount(tweet.getAmount());
            consumedTweet.setPublish(tweet.getPublish());
            tweetConsumerRepository.save(consumedTweet);

//            tweetConsumerRepository.save(new ConsumedTweet(
//                    tweet.getRaw(), tweet.getAmount()));

            System.out.println("Consumed tweet " + tweet.getRaw());
        }

    }
}
