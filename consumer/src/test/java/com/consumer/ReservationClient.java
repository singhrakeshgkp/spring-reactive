package com.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
@Component
public class ReservationClient {

  private final WebClient client;
  ReservationClient(WebClient client){
    this.client = client;
  }
  Flux<Reservation>  getAllReservations(){

    return  this.client
        .get()
        .uri("/reservation")
        .retrieve()
        .bodyToFlux(Reservation.class);

  }
}
