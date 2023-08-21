# Table of contents
- [About](#about)
- [Producer Project Setup](#project-setup)
- [Writing Tests](#writing-tests)
  - [Writing Tests For Pojo](#writing-tests-for-pojo)
  - [Writing Tests For Entity](#writing-tests-for-entity)
  - [Writing Tests For Repository](#writing-tests-for-repository)
  - [Writing Tests For Web Tier](#writing-tests-for-web-tier)
- [Consumer Project Setup](#consumer-project-setup)
  ## About
  Here we will create a project, that will follow the test first approach.
  ## Project Setup
  - Create new project using Spring web reactive, lombok, contract verifier and mongo db reactive support dependency.
 ## Writing Tests   
### Writing Tests For Pojo
- Create a ```ReservationTest``` class to test ```Reservation``` Pojo
- Create a ```Reservation``` pojo class
- Write and verify the test.
### Writing Tests For Entity
- Create a ```ReservationEntityTest``` class. Write the test method, execute it and see the database collection, record should be present
### Writing Tests For Repository
- Create a ```ReservationRepositoryQueryTest``` and ```ReservationRepository``` class. 
- Create the query test mehtod and run the test.

### Writing Tests for Web tier
- Create a new class ```ReservationHttpTest``` and write the required test.

## Consumer project Setup
- Create new project named ```consumer``` with the following dependencies
  ```
  spring reactive(sr) web, contract stub runner and lombock
  ```
### Writing and executing test cases if target server is up and running
- Write the test case in ```ConsumerApplicationTests.java``` class code is given below.
  ```
  package com.consumer;

import java.util.function.Predicate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ConsumerApplicationTests {

	@Autowired
	ReservationClient client;
	@Test
	void contextLoads() {

		StepVerifier
				.create(this.client.getAllReservations())
				.expectNextMatches(p("1","rakesh"))
				.expectNextMatches(p("2","suresh"))
				.verifyComplete();
	}

	Predicate<Reservation> p (String id, String name){
		return reservation -> reservation.getId().equalsIgnoreCase(id) && reservation.getReservationName().equalsIgnoreCase(name);
	}

}

  ```
- Create a reservation client class
```
  package com.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
@Component
public class ReservationClient {

  private final WebClient client;
  ReservationClient(WebClient client){
    this.client = client;
  }
  Flux<Reservation>  getAllReservations(){

    return  this.client
        .get()
        .uri("/reservation")
        .retrieve()
        .bodyToFlux(Reservation.class);

  }
}

```
- Create a reservation pojo class
- Create a new bean of type WebClient class in ```ConsumerApplication.java``` class
```
@Bean
	WebClient client(WebClient.Builder builder){
		return  builder
				.baseUrl("http://localhost:8080")
				.build();
	}
```
- Execute the test if target server is up an running and record exit in the database test will be pass.
