package com.reactiveex.reactiveweb2.handler;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface CustomerHandler {
    public Mono<ServerResponse> getAll(ServerRequest req);
}
