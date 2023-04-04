package com.reactiveex.reactiveweb7.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class TestController {

    @GetMapping(value = "/test1", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<String> test1(){
        return Mono.just("hello world");
    }
}
