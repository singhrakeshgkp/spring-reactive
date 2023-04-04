package com.reactiveex.reactiveweb4.controller;

import com.reactiveex.reactiveweb4.subscribers.TestSubscriber;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;
import java.util.stream.Stream;

@RestController
public class TestController {

    @GetMapping("/msg1")
    public void msg1() {

        /*various ways to create flux and mono*/
    /*var flux1 = Flux.just(4, 5, 6, 7, 8, 9);
    var flux2 = Flux.fromStream(Stream.of(1, 2, 3, 4, 5, 6, 7));
    var flux3 = Flux.fromIterable(Set.of(2, 2, 4, 4, 3, 6, 7, 7));
    Integer[] numArray = {2, 3, 4, 5, 6, 7};
    var flux4 = Flux.fromArray(numArray);

    var mono1 = Mono.just(55);*/
        var flux = Flux.fromIterable(Set.of(2, 3, 4, 5, 6));
        flux.doOnNext(ele -> System.out.println(ele))
                .subscribe(ele -> System.out.println("subs" + ele));
    }

    @GetMapping("/msg2")
    public void msg2(){
        var flux = Flux.fromIterable(Set.of(2, 3, 4, 5, 6));
                   flux.doOnNext(ele->{throw new RuntimeException("exception thrown");})//this will call onError method
                           .subscribe(new TestSubscriber());
    }
}
