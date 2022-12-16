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
@RequestMapping("/a")
public class TweetController {

    private TweetRepository tweetRepository;

    public TweetController(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

//    todo: przeniesc do consumer, bo to consumer bedzie wyszykiwal po key work z bazy
//    @GetMapping("/filterBy/{searchWord}")
//    public void sendUserData(@PathVariable String searchWord) {
//        User user = new User();
//        user.setAge(123);
//        user.setName(searchWord);
//        service.sendUserData(user);
//    }

    @GetMapping("/b/{searchWord}")
    public List getTweetsBySearchWord(@PathVariable String searchWord) {
        List<Tweet> tweetsFromDb = tweetRepository.findByRawContaining(searchWord);

        //System.out.println("/searchBy/{searchWord}" + tweetsFromDb.get(0).getRaw());
        //todo: save them in different table
        return tweetsFromDb;
    }

}