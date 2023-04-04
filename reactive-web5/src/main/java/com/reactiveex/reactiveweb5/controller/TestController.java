package com.reactiveex.reactiveweb5.controller;

import com.reactiveex.reactiveweb5.controller.subscribers.TestSubscriber;
import com.reactiveex.reactiveweb5.publishers.TestPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
public class TestController {
    @GetMapping("/test1")
    public void test1(){
        TestPublisher publisher = new TestPublisher(List.of(1,2,3,4,5,6,7,8,9));
        publisher.subscribe(new TestSubscriber());
    }

    @GetMapping("/test2")
    public void test2(){

        Flux<String> flux = Flux.create(sink->{
            for(int i =0;i<5;i++){
               sink.next("ele "+i);
            }
            sink.complete();
        });
        flux.subscribe(ele-> System.out.println(ele));
        }

    @GetMapping("/test3")
    public void test3(){

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
