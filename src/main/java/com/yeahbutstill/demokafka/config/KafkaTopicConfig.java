package com.yeahbutstill.demokafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic yeahButStillTopic() {
        return TopicBuilder.name("yeahbutstill-events").build();
    }

    @Bean
    public NewTopic yeahButStillJsonTopic() {
        return TopicBuilder.name("yeahbutstillJson-events").build();
    }

}
