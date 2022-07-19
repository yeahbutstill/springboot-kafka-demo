package com.yeahbutstill.demokafka.kafka;

import com.yeahbutstill.demokafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "yeahbutstillJson-events", groupId = "myGroup")
    // spring kafka provided JsonDeserializer will convert User Json object into Java User object
    public void consume(User user) {

        LOGGER.info("Json message recieved: {}", user);

    }

}
