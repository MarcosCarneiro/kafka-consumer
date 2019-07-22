package com.kafka.consumer.kafkaconsumer.repositories;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.kafka.consumer.kafkaconsumer.modelsVO.TedVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TedRepository {

    private static final Logger logger = LoggerFactory.getLogger(TedRepository.class);

    @Autowired
    private DynamoDBMapper mapper;

    public void insert(TedVO tedVO) {
        mapper.save(tedVO);
    }
}
