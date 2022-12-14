//package com.kafka.customdeserializers;
//
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.clients.consumer.ConsumerRecords;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//import org.apache.kafka.common.serialization.StringDeserializer;
//
//import java.time.Duration;
//import java.util.Collections;
//import java.util.Properties;
//
//public class OrderConsumer {
//    public static void main(String[] args) {
//        Properties props = new Properties();
//        props.setProperty("bootstrap.servers", "localhost:9092");
////        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
////        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.IntegerDeserializer");
//        props.setProperty("key.deserializer", StringDeserializer.class.getName());
//        props.setProperty("value.deserializer", OrderDeserializer.class.getName());
//        props.setProperty("group.id", "OrderCSGroup");
//        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//
//
//        KafkaConsumer<String, Order> consumer = new KafkaConsumer<>(props);
//        consumer.subscribe(Collections.singletonList("OrderCSTopic"));
//
//        while(true) {
//            ConsumerRecords<String, Order> records = consumer.poll(Duration.ofSeconds(20));
//            for (ConsumerRecord<String, Order> record : records) {
////            System.out.println("Product name " + record.key());
////            System.out.println("Quantity " + record.value());
//                String consumerName = record.key();
//                Order order = record.value();
//                System.out.println("Customer name: " + order.getCustomerName());
//                System.out.println("Product: " + order.getProduct());
//                System.out.println("Quantity: " + order.getQuantity());
//            }
//        }
////        consumer.close();
//
////        } catch (Exception e) {
////            e.printStackTrace();
////        } finally {
////            consumer.close();
//
//    }
//}
