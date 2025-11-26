package com.edificando.edificando_web_api.infrastructure.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Todas las rutas de Angular (excepto las APIs) redirigen a index.html
        registry.addViewController("/{spring:[a-zA-Z0-9-_]+}")
                .setViewName("forward:/index.html");
        registry.addViewController("/{spring:[a-zA-Z0-9-_]+}/**")
                .setViewName("forward:/index.html");
    }
}

