package com.reactive.handler;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import com.reactive.model.Customer;
import com.reactive.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class CustomerHandlerImpl implements  CustomerHandler{

  @Autowired
  CustomerService customerService;

  @Override
  public Mono<ServerResponse> getAllCustomers(ServerRequest serverRequest) {
    return ok()
        .contentType(MediaType.TEXT_EVENT_STREAM)
        .body(customerService.getAllCustomer(), Customer.class);
  }
}
