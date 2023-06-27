package com.reactive;

import com.reactive.clients.GreetingClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ReactiveWeb1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ReactiveWeb1Application.class,args);
		GreetingClient client = context.getBean(GreetingClient.class);

		//used .block to avoid jvm exit before printing logs
		System.out.println("msg from reactive greeting application = "+client.getMessage().block());
	}

}
