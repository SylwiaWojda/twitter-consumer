package com.kafka.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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