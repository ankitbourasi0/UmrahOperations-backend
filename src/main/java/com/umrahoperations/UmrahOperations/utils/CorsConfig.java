package com.umrahoperations.UmrahOperations.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://www.umraoperation.com","http://umraoperation.com","http://localhost:4173","http://localhost:4173/umrah-frontend", "http://localhost:5173",  "http://localhost:5173/umrah-frontend", "http://52.66.75.230:8080", "http://52.66.75.230:8080/umrah-frontend" ,"http://52.66.75.230",  "http://52.66.75.230/umrah-frontend","http://localhost:9090" , "http://localhost:9090/umrah-frontend")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(false);

//                .allowedOrigins("http://localhost:5173")

    }
}