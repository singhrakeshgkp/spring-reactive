package com.producer;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

@ExtendWith(SpringExtension.class)
@WebFluxTest(value = ReservationHttpConfiguration.class)
/*here value = ReservationHttpConfiguration.class prop used to locad the bean as here we are
* performing slice testing so bean available in that class won't be loaded in the context.*/
public class ReservationHttpTest {

  @Autowired
  WebTestClient client;

  @MockBean
  ReservationRepository repository;
  /*since we have already tested repisitory so will not be writing test here. henced mocked the repository*/
  @Test
  public void get(){
    /*step 1.write the below test
    * step 2 Introduce new HttpEndpoint
    * step 3 involve ReservationHttpConfiguration in @webFluxTest annotation
    * step 4 create a mock bean named reservation repository
    * */

    /*Step 4 start*/
    Mockito.when(this.repository.findAll())
            .thenReturn(Flux.just(new Reservation("1","rakesh"), new Reservation("2","rajesh")));
    /*step 4 end*/
    client.get()
        .uri("/reservation")
        .exchange()
        .expectStatus().isOk()
        .expectHeader().contentType(MediaType.APPLICATION_JSON)
        .expectBody().jsonPath("@.[0].name").isEqualTo("rakesh")
        .jsonPath("@.[1].name").isEqualTo("rajesh");

  }
}
