package com.umsa.proyec_admin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/*") // Apply to all endpoints
                        .allowedOrigins("") // Allow any origin
                        .allowedMethods("") // Allow any HTTP method
                        .allowedHeaders(""); // Allow any header
            }
        };
    }
}