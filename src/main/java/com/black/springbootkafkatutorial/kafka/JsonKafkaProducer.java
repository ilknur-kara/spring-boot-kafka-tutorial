package com.black.springbootkafkatutorial.kafka;

import com.black.springbootkafkatutorial.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);
    private static final String MY_SECOND_TOPIC = "my_second_topic";
    private KafkaTemplate<String, User> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * This method creates a json message object and sends it to the kafka topic.
     * @param user
     */
    public void sendMessageJSON(User user) {
        LOGGER.info(String.format("JSON Message is sent -> %s", user.toString()));

        Message<User> message = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, MY_SECOND_TOPIC)
                .build();

        kafkaTemplate.send(message);
    }
}
