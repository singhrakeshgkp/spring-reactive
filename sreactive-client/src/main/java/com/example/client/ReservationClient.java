package com.example.client;

import com.example.model.Reservation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
@AllArgsConstructor
public class ReservationClient {

private final WebClient webClient;

public Flux<Reservation> getReservations(){
    return this.webClient
            .get()
            .uri("http://localhost:8080/reservations")
            .retrieve()
            .bodyToFlux(Reservation.class);
}

}
