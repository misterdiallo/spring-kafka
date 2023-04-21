package com.misterdiallo.backend.springkafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.misterdiallo.backend.springkafka.config.KafkaConfig;
import com.misterdiallo.backend.springkafka.domain.CustomerVisitEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootApplication
public class SpringKafkaApplication {
    @Autowired
    private ObjectMapper objectMapper;

    public static void main(String[] args) {
        SpringApplication.run(SpringKafkaApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner(final KafkaTemplate<String, String> kafkaTemplate, final KafkaConfig kafkaConfig) throws JsonProcessingException {
        final CustomerVisitEvent event = CustomerVisitEvent.builder()
                .customerId(UUID.randomUUID().toString())
                .dateTime(LocalDateTime.now())
                .build();
        final  String payload = objectMapper.writeValueAsString(event);
        return args -> {
            kafkaTemplate.send(kafkaConfig.getTopic() , payload);
        };
    }

    @KafkaListener(topics = "customer.visit")
    public String listens(final String in) {
        System.out.println(in);
        return in;
    }
}
