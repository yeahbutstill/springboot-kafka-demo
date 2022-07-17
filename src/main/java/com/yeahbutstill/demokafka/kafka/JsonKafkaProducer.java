package com.yeahbutstill.demokafka.kafka;

import com.yeahbutstill.demokafka.payload.User;
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

    private final KafkaTemplate<String, User> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User dataUser) {

        LOGGER.info(String.format("Message send -> %s", dataUser.toString()));
        LOGGER.info("Message send: {}", dataUser);

        Message<User> message = MessageBuilder
                .withPayload(dataUser)
                .setHeader(KafkaHeaders.TOPIC, "yeahbutstill-events")
                .build();

        kafkaTemplate.send(message);

    }

}
