package com.producer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)// @RunWith replaced by this given annotation.
@DataMongoTest//for slice testing,brings back only MongoDB Context
public class ReservationEntityTest {

  @Autowired
  ReactiveMongoTemplate  reactiveMongoTemplate;

  @Test
  public void persist(){
    Mono<Reservation>  jane = reactiveMongoTemplate.save(new Reservation(null,"jane"));
    StepVerifier
        .create(jane)
        .expectNextMatches(reservation->reservation.getName().equalsIgnoreCase("jane") && reservation.getId() != null)
        .verifyComplete();
  }
}
