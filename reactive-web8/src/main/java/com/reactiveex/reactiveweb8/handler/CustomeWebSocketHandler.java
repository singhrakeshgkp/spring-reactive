package com.reactiveex.reactiveweb8.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import java.time.Duration;
import java.util.UUID;

@Component
public class CustomeWebSocketHandler implements WebSocketHandler {

    @Autowired
    private Sinks.Many<String> sinks;
    @Override
    public Mono<Void> handle(WebSocketSession session) {
       var flux =  sinks.asFlux()
               .map(e->session.textMessage(e));
              // .delayElements(Duration.ofSeconds(1));
        return session.send(flux);
    }
}
