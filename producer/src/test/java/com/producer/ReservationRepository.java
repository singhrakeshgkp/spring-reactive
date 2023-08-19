package com.producer;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReservationRepository  extends ReactiveMongoRepository<Reservation,String> {

  Flux<Reservation> findByName(String name);
}
