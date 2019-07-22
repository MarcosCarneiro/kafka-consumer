package com.kafka.consumer.kafkaconsumer.engine;

import com.kafka.consumer.kafkaconsumer.modelsVO.TedVO;
import com.kafka.consumer.kafkaconsumer.repositories.TedRepository;
import org.apache.avro.generic.GenericRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import static javax.management.Query.value;

@Service
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    private TedRepository tedRepository;

    @KafkaListener(topics = "topic-hamburgo-test", groupId = "group_id")
    public void consume(GenericRecord message) throws IOException {

        logger.info(String.format("#### -> show message -> %s", message));

        TedVO tedVO = this.buildTed(message);

        //SAVE IN DYNAMO
        //tedRepository.insert(tedVO);
    }

    private TedVO buildTed(GenericRecord genericRecord){
        TedVO tedVO = TedVO.builder()
                .id((int) genericRecord.get(TedVO.FIELD_ID))
                .dateProcessing(LocalDate.parse(genericRecord.get(TedVO.FIELD_DATE_PROCESSING).toString()))
                .value(new BigDecimal(genericRecord.get(TedVO.FIELD_VALUE).toString()))
                .sourceBank(genericRecord.get(TedVO.FIELD_SOURCE_BANK).toString())
                .sourceAgency(genericRecord.get(TedVO.FIELD_SOURCE_AGENCY).toString())
                .sourceAccount(genericRecord.get(TedVO.FIELD_SOURCE_ACCOUNT).toString())
                .destinationBank(genericRecord.get(TedVO.FIELD_DESTINATION_BANK).toString())
                .destinationAgency(genericRecord.get(TedVO.FIELD_DESTINATION_AGENCY).toString())
                .destinationAccount(genericRecord.get(TedVO.FIELD_DESTINATION_ACCOUNT).toString())
                .build();

        return tedVO;
    }
}
