package com.producer;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Configuration
public class ReservationHttpConfiguration {

  @Bean
  RouterFunction<ServerResponse> routes(ReservationRepository repository){
    return  route()
        .GET("/reservation",
            request -> ServerResponse.ok().body(repository.findAll(),Reservation.class)).build();


  }
}
