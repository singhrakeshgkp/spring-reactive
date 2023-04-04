package com.reactiveex.reactiveweb2.config;

import com.reactiveex.reactiveweb2.handler.CustomerHandler;
import com.reactiveex.reactiveweb2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterConfig {

    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerHandler customerHandler;
    @Bean
    public RouterFunction<ServerResponse> router() {
        return route().GET("/customers", customerHandler::getAll)
                .build();


    }
}
