package com.example.useraccountapi.service;

import com.example.useraccountapi.entities.Deuda;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {


    @Bean(name = "clienteRest")
    public RestTemplate registrarRestTemplate(){
        return new RestTemplate();
    }

}
