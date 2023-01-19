package com.kafka.spring;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Tweet_details_consumed")
public class ConsumedTweet {
    @Id
    @GeneratedValue
    private Integer id;


    @Column(length = 65555000)
    private String raw;

    private String amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public ConsumedTweet(String raw, String amount) {
        this.raw = raw;
        this.amount = amount;
    }


    public ConsumedTweet() {
    }

}
