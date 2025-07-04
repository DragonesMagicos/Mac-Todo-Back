package com.techlab.ferreteria_api;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull; // <-- Importante agregar esta línea
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(@NonNull CorsRegistry registry) { // <-- LA SOLUCIÓN: Agregar @NonNull aquí
        registry.addMapping("/api/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*");
    }
}
