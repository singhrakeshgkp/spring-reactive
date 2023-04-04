package com.springreactivecore.testexample;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class MonoAndFluxTestExample {
	/*
	 * verifyComplete() or verify method of stepverifier is responsible for subscribing the stream
	 * */
	
	//@Test
	public void monoOnSuccessTest() {
		Mono<String> mono = Mono.just("cassandra").log();
		StepVerifier.create(mono)
					.expectNext("cassandra")
					.verifyComplete();
	}
	
	@Test
	public void monoOnErrorTest() {
		Mono<Object> mono = Mono.error(new RuntimeException("exception occurred")).log();
		StepVerifier.create(mono)
					.expectError(RuntimeException.class)
					.verify();
	}
	//@Test
	public void fluxOnCompleteTest() {
		Flux<String> flux = Flux.just("security","cassandra")
				.log();
		StepVerifier.create(flux)
		.expectNext("security","cassandra")
		.verifyComplete();
	}
	
	//@Test
	public void fluxExceptionTest() {
		Flux<String> flux = Flux.just("security","cassandra","mysql")
				.concatWith(Flux.error(new RuntimeException("exception occurred")))
				.log();
		StepVerifier.create(flux)
		.expectNext("security")
		.expectNext("cassandra")
		.expectNext("mysql")
		.verifyError(RuntimeException.class);
	}
}
