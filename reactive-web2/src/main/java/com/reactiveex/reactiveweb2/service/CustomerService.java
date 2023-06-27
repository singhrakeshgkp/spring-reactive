package com.reactiveex.reactiveweb2.service;

import com.reactiveex.reactiveweb2.model.Customer;
import com.reactiveex.reactiveweb2.proxy.CustomerProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CustomerService {

    @Autowired
    private  CustomerProxy customerProxy;
    public Flux<Customer> getAllCustomer() {
        return customerProxy.getAllCustomer();
    }

}
