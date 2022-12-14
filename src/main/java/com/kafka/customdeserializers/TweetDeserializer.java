package com.kafka.customdeserializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.spring.Tweet;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class TweetDeserializer implements Deserializer<Tweet[]> {

    @Override
    public Tweet[] deserialize(String s, byte[] data) {
        ObjectMapper objectMapper = new ObjectMapper();
        Tweet[] order = null;
        try {
            order = objectMapper.readValue(data, Tweet[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return order;
    }
}
