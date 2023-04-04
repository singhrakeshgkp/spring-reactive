package com.example.config;

import com.example.producer.GreetingProducer;
import com.example.request.GreetingRequest;
import com.example.response.GreetingResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@Configuration
public class WebSocketConfig {

    @Bean
    SimpleUrlHandlerMapping simpleUrlHandlerMapping(WebSocketHandler wsh){
        return new SimpleUrlHandlerMapping(){
            {
                setUrlMap(Map.of("ws/greetings",wsh));
                setOrder(10);
            }
        };
    }

    @Bean
    WebSocketHandlerAdapter webSocketHandlerAdapter(){
        return new WebSocketHandlerAdapter();
    }

    @Bean
    WebSocketHandler webSocketHandler(GreetingProducer greetingProducer){
        return session -> {
           var response = session
                    .receive()
                    .map(WebSocketMessage::getPayloadAsText)
                    //.map(name->new GreetingRequest(name))
                     .map(GreetingRequest::new)
                   // .flatMap(greetingRequest -> greetingProducer.greet(greetingRequest))
                     .flatMap(greetingProducer::greet)
                    .map(GreetingResponse::getMessage)
                    .map(session::textMessage);
            return session.send(response);
        };
    }
}
