package com.flavio.estudos.spring.hrpayload.hrpayload.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate registerRestTemplate(){
        return  new RestTemplate();
    }
}
