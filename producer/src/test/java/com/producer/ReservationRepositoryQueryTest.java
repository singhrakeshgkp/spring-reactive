package com.producer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@DataMongoTest
@ExtendWith(SpringExtension.class)
public class ReservationRepositoryQueryTest {

  @Autowired
  ReservationRepository repository;
  @Test
  public void query(){

    /*Step 1. delete existing record
    * Step2. Save the record
    * step 3. query the data by name
    * step 4. apply the required assertions*/
    Flux<Reservation> result = this.repository.deleteAll().thenMany(
    Flux.just("rakesh","sunil","ranvijay")
        .map(name->new Reservation(null,name))
        .flatMap(re->this.repository.save(re)))
        .thenMany(this.repository.findByName("rakesh"));

    StepVerifier.create(result)
        .expectNextCount(1)
        .verifyComplete();
  }
}
