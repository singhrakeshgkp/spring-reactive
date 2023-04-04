package com.example.producer;


import com.example.request.GreetingRequest;
import com.example.response.GreetingResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Supplier;
import java.util.stream.Stream;

@Component
public class GreetingProducer {

    public Flux<GreetingResponse> greet(GreetingRequest greetingRequest){
     return    Flux.fromStream(Stream.generate(()->new GreetingResponse("hello "+greetingRequest.getName()+"@"+ Instant.now()+"!")))
                .delayElements(Duration.ofSeconds(1));
    }
}
