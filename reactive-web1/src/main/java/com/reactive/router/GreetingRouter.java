package com.reactive.router;

import com.reactive.handler.GreetingHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicate;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration(proxyBeanMethods = false)
public class GreetingRouter {

  @Bean
  public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler){
    return RouterFunctions
        .route(GET("/hello-world").and(accept(MediaType.APPLICATION_JSON)),greetingHandler::helloworld);
  }
}
