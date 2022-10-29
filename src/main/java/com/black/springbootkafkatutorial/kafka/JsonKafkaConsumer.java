package com.black.springbootkafkatutorial.kafka;

import com.black.springbootkafkatutorial.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);
    private static final String MY_SECOND_TOPIC = "my_second_topic";

    @KafkaListener (topics = MY_SECOND_TOPIC, groupId = "myGroup")
    public void consume(User user) {
        LOGGER.info(String.format("JSON Message is started to read -> %s",user));
    }
}
