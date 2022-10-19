package com.kafka.customdeserializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class OrderDeserializer implements Deserializer<Order> {

    @Override
    public Order deserialize(String s, byte[] data) {
        ObjectMapper objectMapper = new ObjectMapper();
        Order order = null;
        try {
            order = objectMapper.readValue(data, Order.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return order;
    }
}
