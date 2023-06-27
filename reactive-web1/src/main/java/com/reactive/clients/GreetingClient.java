package com.reactive.clients;

import com.reactive.model.Greeting;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class GreetingClient {

  private final WebClient webClient;

  public  GreetingClient(WebClient.Builder builder){
    this.webClient = builder.baseUrl("http://localhost:8080").build();
  }

  public Mono<String> getMessage(){
    return  webClient.get().uri("/hello-world").accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .bodyToMono(Greeting.class)
        .map(Greeting::getMsg);
  }
}
