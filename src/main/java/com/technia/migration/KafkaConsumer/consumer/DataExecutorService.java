package com.technia.migration.KafkaConsumer.consumer;

import com.technia.migration.producer.model.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataExecutorService implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataExecutorService.class);
    private final Data data;

    public DataExecutorService(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        System.out.println(this.data);
        LOGGER.info("This is the received message: {}",this.data);
    }
}
