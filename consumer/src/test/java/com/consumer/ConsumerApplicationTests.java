package com.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.client.WireMock;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJson;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
@SpringBootTest
/*wire mock step 1*/
@AutoConfigureWireMock(port = 8080)
/*WireMock step 3 autoconfigure json*/
@AutoConfigureJson
class ConsumerApplicationTests {

	@Autowired
	ReservationClient client;
	/*Wire mock Step 4 autoiwre object mapper*/
	@Autowired
	ObjectMapper mapper;

	@Test
	void contextLoads() throws JsonProcessingException {
		/*wire mock step5 creae data*/
		List<Reservation> rserList = Arrays.asList(new Reservation("1","rakesh"), new Reservation("2","suresh"));
    String json = this.mapper.writeValueAsString(rserList);
    /*wire mock step 2*/
		WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/reservation"))
				.willReturn(WireMock.aResponse()
						.withBody(json)
						.withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
						.withStatus(HttpStatus.OK.value())
				));
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
