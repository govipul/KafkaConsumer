package com.technia.migration.KafkaConsumer.config;

import com.technia.migration.producer.model.Data;
import com.technia.migration.producer.model.Relationship;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConfig {

    public Map<String, Object> getConfig(){
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_json");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return config;
    }

    @Bean
    public ConsumerFactory<String, Data> consumerDataConfig(){
        return new DefaultKafkaConsumerFactory<String, Data>(getConfig(), new StringDeserializer(),
                new JsonDeserializer<>(Data.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Data> kafkaDataListener(){
        ConcurrentKafkaListenerContainerFactory<String, Data> listener = new ConcurrentKafkaListenerContainerFactory<>();
        listener.setConsumerFactory(consumerDataConfig());
        return listener;
    }

    @Bean
    public ConsumerFactory<String, Relationship> consumerRelationConfig(){
        return new DefaultKafkaConsumerFactory<String, Relationship>(getConfig(), new StringDeserializer(),
                new JsonDeserializer<>(Relationship.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Relationship> kafkaRelationListener(){
        ConcurrentKafkaListenerContainerFactory<String, Relationship> listener = new ConcurrentKafkaListenerContainerFactory<>();
        listener.setConsumerFactory(consumerRelationConfig());
        return listener;
    }
}
