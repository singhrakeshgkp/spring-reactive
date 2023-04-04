package com.example;

import io.rsocket.transport.netty.client.TcpClientTransport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.tcp.TcpClient;

@SpringBootApplication
public class SreactiveClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SreactiveClientApplication.class, args);
	}

	@Bean
	WebClient client(WebClient.Builder builder){
		return builder.build();
	}

	@Bean
	RSocketRequester rsocket(RSocketRequester.Builder builder){
		return builder.tcp("localhost", 6060);
	}
}
