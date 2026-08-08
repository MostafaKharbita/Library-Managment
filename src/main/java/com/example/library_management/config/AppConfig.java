package com.example.library_management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public String applicationMessage() {
        return "Welcome to Library Management System";
    }

}