package com.technia.migration.KafkaConsumer.consumer;

import com.technia.migration.producer.model.Data;
import com.technia.migration.producer.model.Relationship;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class KafkaConsumer {


        private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
        private static final String TOPIC_OBJECTS = "objects_json";
        private static final String TOPIC_RELATIONSHIP = "relationship_json";
        private static final ExecutorService SERVICE = Executors.newFixedThreadPool(10);

        @KafkaListener(topics = TOPIC_RELATIONSHIP, containerFactory = "kafkaRelationListener")
        public void consumeRelationship(Relationship data) throws IOException {
                LOGGER.info(String.format("#### -> Consumed String message -> %s", data));
        }

        @KafkaListener(topics = TOPIC_OBJECTS, containerFactory = "kafkaDataListener")
        public void consumeObjects(Data data) {
            LOGGER.info(String.format("#### -> Consumed message -> %s", data));
            SERVICE.submit(new DataExecutorService(data));
        }
}
