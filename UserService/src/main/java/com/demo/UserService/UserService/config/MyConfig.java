package com.demo.UserService.UserService.config;

import lombok.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MyConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
