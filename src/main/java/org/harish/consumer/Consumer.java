package org.harish.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.harish.consumer.customdeserializer.Order;
import org.harish.consumer.customdeserializer.OrderDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class Consumer {
    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers","localhost:9092");
        properties.setProperty("key.deserializer", StringDeserializer.class.getName());
        properties.setProperty("value.deserializer", OrderDeserializer.class.getName());
        properties.setProperty("group.id","order");

        KafkaConsumer kafkaConsumer = new KafkaConsumer(properties);
        kafkaConsumer.subscribe(Collections.singleton("order2-topic"));
        ConsumerRecords<String, Order> consumerRecords = kafkaConsumer.poll(Duration.ofSeconds(20));
        for (ConsumerRecord consumerRecord : consumerRecords){
            System.out.println(consumerRecord.key());
            System.out.println(((Order)consumerRecord.value()).getProduct());
        }

    }
}