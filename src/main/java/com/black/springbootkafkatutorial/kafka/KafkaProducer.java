package com.black.springbootkafkatutorial.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    //In order to send a message to the topic we'll use KafkaTemplate.
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String MY_FIRST_TOPIC = "my_first_topic";

    //Constructor based dependency injection
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        LOGGER.info(String.format("Message sent %s", message));
        kafkaTemplate.send(MY_FIRST_TOPIC, message);
    }
}
