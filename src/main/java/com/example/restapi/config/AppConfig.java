package com.example.restapi.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Classe de configuração para a aplicação.
 */
@Configuration
public class AppConfig {

    /**
     * Cria um bean RestTemplate para ser usado em toda a aplicação.
     * O RestTemplate é uma classe do Spring que oferece templates para realizar requisições HTTP.
     * @param builder O construtor de RestTemplate.
     * @return Uma instância de RestTemplate.
     */
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
