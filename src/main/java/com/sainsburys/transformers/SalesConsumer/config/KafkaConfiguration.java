package com.sainsburys.transformers.SalesConsumer.config;


import com.acme.avro.STSSales;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;


import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.ErrorHandler;
import org.springframework.kafka.listener.SeekToCurrentErrorHandler;
import org.springframework.retry.RetryPolicy;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;


import java.util.HashMap;
import java.util.Map;

import static io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG;

@EnableKafka
@Configuration
public class KafkaConfiguration {


    @Autowired
    DataConfig dataConfig;



    @Bean
    public ConsumerFactory<String, STSSales> consumerFactory(){
   // public DefaultKafkaConsumerFactory consumerFactory(){

        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092, localhost:9093");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "50000");
        props.put(ConsumerConfig.REQUEST_TIMEOUT_MS_CONFIG,"60000");
        props.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG, "10000");
        props.put(ConsumerConfig.MAX_PARTITION_FETCH_BYTES_CONFIG, 1048576);
        props.put(ConsumerConfig.FETCH_MAX_BYTES_CONFIG,52428800);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, dataConfig.getAuto_offset_reset());
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
      //  props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "io.confluent.kafka.serializers.KafkaAvroDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,KafkaAvroDeserializer.class);
       // props.put(ConsumerConfig."schema.registry.url", "http://127.0.0.1:8081");
        props.put("specific.avro.reader", "true");
        props.put(SCHEMA_REGISTRY_URL_CONFIG, dataConfig.getSchemaRegistryURL());

      // props.put(ConsumerConfig.SPECIFIC_AVRO_READER_CONFIG, true);
      //  schema registry URL ?

        return new DefaultKafkaConsumerFactory<>(props);



    }


    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, STSSales> kafkaListenerContainerFactory(
            ConsumerFactory<String, STSSales> consumerFactory,
            @Qualifier("retryTemplate") RetryTemplate retryTemplate)    {
        ConcurrentKafkaListenerContainerFactory<String, STSSales> factory = new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(consumerFactory);
        factory.setConcurrency(1);
        factory.setStatefulRetry(true);


        //Retry logic

        ContainerProperties containerProperties = factory.getContainerProperties();
        factory.setRetryTemplate(retryTemplate());
        containerProperties.setAckOnError(false);
        //containerProperties.setSyncCommits(true);
        containerProperties.setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);


        factory.setErrorHandler(new SeekToCurrentErrorHandler());
        return factory;
    }


    @Bean(name = "retryTemplate")
    public RetryTemplate retryTemplate() {
        RetryTemplate retryTemplate = new RetryTemplate();
        //System.out.println("This is message from retryTemplate @@@@@@@@");
        retryTemplate.setRetryPolicy(retryPolicy());
        retryTemplate.setBackOffPolicy(backOffPolicy());
        return retryTemplate;
    }

    @Bean
    public ErrorHandler errorHandler() {
        return new SeekToCurrentErrorHandler();
    }


    @Bean
    public RetryPolicy retryPolicy() {
        SimpleRetryPolicy simpleRetryPolicy = new SimpleRetryPolicy();
        simpleRetryPolicy.setMaxAttempts(3);
        return simpleRetryPolicy;
    }

    @Bean
    public FixedBackOffPolicy backOffPolicy() {
        FixedBackOffPolicy backOffPolicy = new FixedBackOffPolicy();
        backOffPolicy.setBackOffPeriod(1000);
        return backOffPolicy;
    }




}
