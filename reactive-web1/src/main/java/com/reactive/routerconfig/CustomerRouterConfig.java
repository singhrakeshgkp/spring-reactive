package com.reactive.routerconfig;

import com.reactive.handler.CustomerHandler;
import com.reactive.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class CustomerRouterConfig {

  @Autowired
  CustomerService customerService;

  @Autowired
  CustomerHandler customerHandler;


  @Bean
  public RouterFunction<ServerResponse> route(){
    return RouterFunctions
        .route().GET("/customers",customerHandler::getAllCustomers)
        .build();
  }
}
