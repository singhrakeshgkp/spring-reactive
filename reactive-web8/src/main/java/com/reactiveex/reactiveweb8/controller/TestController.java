package com.reactiveex.reactiveweb8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Sinks;

@RestController
public class TestController {

    @Autowired
    Sinks.Many<String> sinks;
    @PostMapping("/test1")
    public void test1(){
        sinks.emitNext("hello",Sinks.EmitFailureHandler.FAIL_FAST);
    }
}
