package com.kafka.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/consumer")
public class TweetController {

    private TweetRepository tweetRepository;

    public TweetController(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }


    @GetMapping("/search/{searchWord}")
    public List getTweetsBySearchWord(@PathVariable String searchWord) {
        List<Tweet> tweetsFromDb = tweetRepository.findByRawContaining(searchWord);
        return tweetsFromDb;
    }

}