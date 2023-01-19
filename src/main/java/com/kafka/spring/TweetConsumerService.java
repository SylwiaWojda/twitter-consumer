package com.kafka.spring;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class TweetConsumerService {

    private ConsumedTweetRepository tweetConsumerRepository;

    public TweetConsumerService(ConsumedTweetRepository tweetConsumerRepository) {
        this.tweetConsumerRepository = tweetConsumerRepository;
    }

    @KafkaListener(topics = { "tweet-topic" })
    public void consumerTwitterData(Tweet[] tweets) {
        for(Tweet tweet: tweets) {

            ConsumedTweet consumedTweet = new ConsumedTweet();
            consumedTweet.setRaw(tweet.getRaw());
//            consumedTweet.setRawTweets("0");
            consumedTweet.setAmount(tweet.getAmount());
            tweetConsumerRepository.save(consumedTweet);

//            tweetConsumerRepository.save(new ConsumedTweet(
//                    tweet.getRaw(), tweet.getAmount()));

            System.out.println("Consumed tweet " + tweet.getRaw());
        }

    }
}
