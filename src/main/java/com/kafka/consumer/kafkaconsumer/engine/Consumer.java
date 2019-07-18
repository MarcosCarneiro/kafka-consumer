package com.kafka.consumer.kafkaconsumer.engine;

import org.apache.avro.generic.GenericRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "topic-hamburgo-test", groupId = "group_id")
    public void consume(GenericRecord message) throws IOException {
        logger.info(String.format("#### -> show message -> %s", message));
    }
}
