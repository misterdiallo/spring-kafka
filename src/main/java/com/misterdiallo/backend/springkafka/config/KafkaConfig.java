package com.misterdiallo.backend.springkafka.config;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "misterdiallo.kafka")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KafkaConfig {
    private String topic;

}
