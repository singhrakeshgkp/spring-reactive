package com.example.client;

import com.example.request.GreetingRequest;
import com.example.response.GreetingResponse;
import lombok.AllArgsConstructor;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@AllArgsConstructor
public class GreetingsClient {

    private final RSocketRequester rSocketRequester;
    public Flux<GreetingResponse> greet(GreetingRequest request){
        return rSocketRequester.route("greetings")
                .data(request)
                .retrieveFlux(GreetingResponse.class);
    }
}
