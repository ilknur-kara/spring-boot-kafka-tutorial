package com.black.springbootkafkatutorial.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final String MY_FIRST_TOPIC = "my_first_topic";
    private static final String MY_GROUP = "myGroup";
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    //@KafkaListener provides to listen/subscribe the topic.
    @KafkaListener(topics = MY_FIRST_TOPIC, groupId = MY_GROUP)
    public void consume(String message) {
        LOGGER.info(String.format("Message is started to read -> %s", message));

    }

}
