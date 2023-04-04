package com.reactiveex.reactiveweb2.service;

import com.reactiveex.reactiveweb2.model.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;
import java.util.stream.Stream;

@Service
public class CustomerService {

    public Flux<Customer> getAllCustomer() {
        Stream<Customer> customerStream = Arrays.asList(
                new Customer("rakesh"),
                new Customer("suresh")
        ).stream();
        Flux<Customer> customers = Flux.fromStream(customerStream)
                .delayElements(Duration.ofSeconds(3));
        return customers;

    }

}
