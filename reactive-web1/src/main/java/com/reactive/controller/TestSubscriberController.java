package com.reactive.controller;

import com.reactive.subscribers.TestSubscriber;
import java.util.Set;
import java.util.function.Consumer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class TestSubscriberController {

  @GetMapping("/subs1")
  public void subsriberTest1(){
    var flux = Flux.fromIterable(Set.of(1,2,3,4,5,6,7,8,9));
    flux.log()
        .subscribe(ele -> System.out.println("subs " + ele));
  }

  @GetMapping("/subs2")
  public void subsriberTest2(){

    var flux = Flux.fromIterable(Set.of(2, 3, 4, 5, 6));
   // flux.doOnNext(ele->{throw new RuntimeException("exception thrown");})//this will call onError method
       flux.doOnNext(ele->System.out.println(ele))
        .subscribe(new TestSubscriber());
  }
}
