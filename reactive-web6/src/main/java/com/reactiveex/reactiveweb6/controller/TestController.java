package com.reactiveex.reactiveweb6.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class TestController {

    @GetMapping(value = "/test1", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> test1(){
        Flux<String> flux = Flux.just("rakesh","s","mm","rakesh");
        return flux.log()
                .filter(name->name.length()>1)
                .distinct();
    }
}
