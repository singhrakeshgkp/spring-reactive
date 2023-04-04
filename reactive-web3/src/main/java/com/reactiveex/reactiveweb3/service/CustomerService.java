package com.reactiveex.reactiveweb3.service;

import com.reactiveex.reactiveweb3.model.Customer;
import com.reactiveex.reactiveweb3.proxy.CustomerProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;
import java.util.stream.Stream;

@Service
public class CustomerService {

    @Autowired
    private  CustomerProxy customerProxy;
    public Flux<Customer> getAllCustomer() {
        return customerProxy.getAllCustomer();
    }

}
