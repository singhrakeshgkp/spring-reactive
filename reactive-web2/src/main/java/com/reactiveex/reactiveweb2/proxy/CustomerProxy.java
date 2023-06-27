package com.reactiveex.reactiveweb2.proxy;

import com.reactiveex.reactiveweb2.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import reactor.core.publisher.Flux;

@Component
public class CustomerProxy {

    @Autowired
    WebClient webClient;

    /*There are n number of method that can be used such as
    *retry, resume, return ...etc
    * */
    public Flux<Customer> getAllCustomer(){
      return   webClient.get().uri("/customers")
                .exchangeToFlux(res->res.bodyToFlux(Customer.class))
              .onErrorResume(WebClientException.class,e->{
                  Customer customer = new Customer("demo customer");
                  return Flux.just(customer);
              });
    }
}
