package com.example.config;

import com.example.documents.Reservation;
import com.example.repository.ReservationRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class HttpConfiguration {

    @Bean
    RouterFunction<ServerResponse> routes(ReservationRepo reservationRepo){
        return  route()
                .GET("/reservations",serverRequest->ok().body(reservationRepo.findAll(), Reservation.class))
                //.POST()
                //.PUT()
                //.DELETE()
                .build();
    }
}
