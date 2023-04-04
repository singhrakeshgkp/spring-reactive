package com.example.controller;

import com.example.producer.GreetingProducer;
import com.example.request.GreetingRequest;
import com.example.response.GreetingResponse;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
@AllArgsConstructor
public class RsocketGreetingsController {

    private  final GreetingProducer producer;

     @MessageMapping("greetings")
    Flux<GreetingResponse> greet(GreetingRequest greetingRequest){

        return this.producer.greet(greetingRequest);
     }
}
