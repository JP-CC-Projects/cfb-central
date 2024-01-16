package com.jpcc.CFBProject.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonNoSnakeConfig {

    @Bean
    @Qualifier("noSnakeObjectMapper")
    public ObjectMapper noSnakeObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        // Configure your custom ObjectMapper settings here
        // For example, set property naming strategy, date format, etc.
        return objectMapper;
    }
}