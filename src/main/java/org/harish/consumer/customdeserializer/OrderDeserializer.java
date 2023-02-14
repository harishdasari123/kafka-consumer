package org.harish.consumer.customdeserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class OrderDeserializer implements Deserializer<Order> {


    @Override
    public Order deserialize(String s, byte[] bytes) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(bytes, Order.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
