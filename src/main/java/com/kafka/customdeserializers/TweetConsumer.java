package com.kafka.customdeserializers;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import static java.lang.Thread.sleep;

public class TweetConsumer {
    public static void main(String[] args) throws InterruptedException {
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "localhost:9092");
        props.setProperty("key.deserializer", StringDeserializer.class.getName());
        props.setProperty("value.deserializer", TweetDeserializer.class.getName());
        props.setProperty("group.id", "TweetGroup");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");


        KafkaConsumer<String, Tweet[]> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList("TweetTopic"));

        while(true) {
            ConsumerRecords<String, Tweet[]> records = consumer.poll(Duration.ofSeconds(20));
            for (ConsumerRecord<String, Tweet[]> record : records) {
//            System.out.println("Product name " + record.key());
//            System.out.println("Quantity " + record.value());
                String consumerName = record.key();
                Tweet[] tweets = record.value();
//                System.out.println("Tweet: " + tweets[1].getRawTweets());
//                System.out.println("Amount: " + tweets[1].getAmount());
            }
            sleep(100000);
        }
//        consumer.close();

//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            consumer.close();

    }
}
