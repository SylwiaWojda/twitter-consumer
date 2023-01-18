//package com.kafka.spring;
//
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//
//@Entity(name = "Tweet_details_consumer")
//public class TweetConsumer {
//    @Id
//    @GeneratedValue
//    private Integer id;
//    @Column(length = 65555000)
//    private String rawTweets;
//
//    @Column(length = 65555000)
//    private String raw;
//
//    private String amount;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getRawTweets() {
//        return rawTweets;
//    }
//
//    public void setRawTweets(String rawTweets) {
//        this.rawTweets = rawTweets;
//    }
//
//    public String getAmount() {
//        return amount;
//    }
//
//    public void setAmount(String amount) {
//        this.amount = amount;
//    }
//
//    public String getRaw() {
//        return raw;
//    }
//
//    public void setRaw(String raw) {
//        this.raw = raw;
//    }
//
//    public TweetConsumer(Integer id, String rawTweets, String raw, String amount) {
//        this.id = id;
//        this.rawTweets = rawTweets;
//        this.raw = raw;
//        this.amount = amount;
//    }
//
//    public TweetConsumer(Integer id, String rawTweets, String amount) {
//        this.id = id;
//        this.rawTweets = rawTweets;
//        this.amount = amount;
//    }
//
//    public TweetConsumer() {
//    }
//
//}
