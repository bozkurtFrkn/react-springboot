package com.carrental.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {

        CorsConfiguration cc = new CorsConfiguration();
        cc.setAllowedOriginPatterns(Arrays.asList("*"));
        cc.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        cc.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token"));
        cc.setExposedHeaders(Arrays.asList("x-auth-token"));
        cc.setAllowCredentials(true);
        cc.setMaxAge(1800L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/**", cc);
        return new CorsFilter(source);
    }
}
