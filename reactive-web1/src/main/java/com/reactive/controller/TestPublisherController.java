package com.reactive.controller;

import com.reactive.publishers.TestPublisher;
import com.reactive.subscribers.TestSubscriber;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class TestPublisherController {

  /*Approach 1*/
  @GetMapping("/test-pub1")
  public void testPub1(){
    TestPublisher publisher = new TestPublisher(List.of(1,2,3,4,5,6,7,8,9));
    publisher.subscribe(new TestSubscriber());
  }

  /*Approach 2*/
  @GetMapping("/test-pub2")
  public void testPub2(){
    Flux<String> flux = Flux.create(sink->{
      for(int i =0;i<5;i++){
        sink.next("ele "+i);
      }
      sink.complete();
    });
    flux.subscribe(ele-> System.out.println(ele));
  }


  /*Approach 3*/
  @GetMapping("/test-pub3")
  public void testPub3(){
    Flux<String> flux = Flux.create(sink->{
      for(int i =0;i<5;i++){
        sink.next("ele "+i);
      }
      sink.complete();
    });
    flux.log()
        .subscribe(ele-> System.out.println(ele));
  }
}
