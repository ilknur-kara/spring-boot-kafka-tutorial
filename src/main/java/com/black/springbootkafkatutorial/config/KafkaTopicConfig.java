package com.black.springbootkafkatutorial.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    private static final String MY_FIRST_TOPIC = "my_first_topic";
    private static final String MY_SECOND_TOPIC = "my_second_topic";

    /**
     * This method creates topic.
     * @return
     */
    @Bean
    public NewTopic createTopic() {
//        TopicBuilder.name("my_first_topic").partitions(10).build(); assigning numb. of partitions.

        return TopicBuilder.name(MY_FIRST_TOPIC)
                .build();
    }

    @Bean
    public NewTopic createTopicForJson() {
        return TopicBuilder.name(MY_SECOND_TOPIC)
                .build();
    }

}
