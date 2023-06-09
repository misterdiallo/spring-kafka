package com.misterdiallo.backend.springkafka.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class JsonConfig {
    @Bean
    public ObjectMapper objectMapper() {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String dataPattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
        objectMapper.setDateFormat(new SimpleDateFormat(dataPattern));
        return objectMapper;
    }
}
