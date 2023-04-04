package com.reactiveex.reactiveweb3.Handler;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface CustomerHandler {
    public Mono<ServerResponse> getAll(ServerRequest req);
}
