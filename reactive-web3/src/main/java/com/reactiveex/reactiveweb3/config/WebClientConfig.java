package com.reactiveex.reactiveweb3.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    // customer service defnined in reactive-web2 application
    @Value("${customer.service.uri}")
    private String customerServiceUri;
    @Bean
    public WebClient webClient(){
        return  WebClient
                .builder()
                .baseUrl(customerServiceUri)
                .build();
    }
}
