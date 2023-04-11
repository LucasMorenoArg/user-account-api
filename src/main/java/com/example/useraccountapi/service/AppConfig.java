package com.example.useraccountapi.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean("usuarioRest")
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }



}
