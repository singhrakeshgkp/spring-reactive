package com.example.config;

import com.example.client.GreetingsClient;
import com.example.client.ReservationClient;
import com.example.model.Reservation;
import com.example.request.GreetingRequest;
import com.example.response.GreetingResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterConfig {



    @Bean
    RouterFunction<ServerResponse> fun(ReservationClient client,
                                       GreetingsClient gc){
        return  route()
                .GET("/sse/greetings/{name}", request -> {
                    var name = request.pathVariable("name");

                  var greetingResponse = gc.greet(new GreetingRequest(name));
                  return ServerResponse.ok()
                          .contentType(MediaType.TEXT_EVENT_STREAM)
                          .body(greetingResponse, GreetingResponse.class);

                })
                .GET("reservations/names",serverRequest->{
                    Flux<String> map = client
                            .getReservations()
                            .map(Reservation::getName)
                            .onErrorResume(throwable->Flux.just("error occurred"))
                            .retry(3);

                    return ServerResponse.ok().body(map,String.class);
                }).build();
    }
}
