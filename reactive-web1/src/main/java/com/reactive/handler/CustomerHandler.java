package com.reactive.handler;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface CustomerHandler {

  public Mono<ServerResponse> getAllCustomers(ServerRequest serverRequest);
}
