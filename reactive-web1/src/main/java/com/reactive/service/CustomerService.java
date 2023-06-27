package com.reactive.service;

import com.reactive.model.Customer;
import java.time.Duration;
import java.util.Arrays;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CustomerService {

  public Flux<Customer> getAllCustomer(){
    Stream<Customer> stream = Arrays.asList(
      new Customer("Rakesh Singh"),
      new Customer("Uday Singh")
    ).stream();
    Flux<Customer> customers = Flux.fromStream(stream)
        .delayElements(Duration.ofSeconds(3));
    return customers;
  }
}
