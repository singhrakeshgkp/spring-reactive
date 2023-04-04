package com.reactiveex.reactiveweb2.handler;

import com.reactiveex.reactiveweb2.model.Customer;
import com.reactiveex.reactiveweb2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class CustomerHandlerImpl implements CustomerHandler {

    @Autowired
    CustomerService customerService;
    public Mono<ServerResponse> getAll(ServerRequest req){
        return ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(customerService.getAllCustomer(), Customer.class);
    }
}
