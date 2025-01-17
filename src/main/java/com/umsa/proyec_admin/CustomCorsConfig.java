package com.umsa.proyec_admin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class CustomCorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOriginPattern(""); // Allow any origin
        config.addAllowedHeader(""); // Allow any header
        config.addAllowedMethod("*"); // Allow any HTTP method
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}