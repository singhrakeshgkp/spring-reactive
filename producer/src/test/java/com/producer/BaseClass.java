package com.producer;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;

@SpringBootTest(
    properties = "server.port=0",webEnvironment = WebEnvironment.RANDOM_PORT,
classes = ProducerApplication.class
)
@ExtendWith(SpringExtension.class)
public class BaseClass {

  @LocalServerPort
  int port;
  @MockBean
  ReservationRepository repository;
  @BeforeEach
  public void init(){
    Mockito.when(this.repository.findAll())
        .thenReturn(Flux.just(new Reservation("1","rakesh"), new Reservation("2","rajesh")));
    RestAssured.baseURI = "http://localhost:"+port;
  }
}
