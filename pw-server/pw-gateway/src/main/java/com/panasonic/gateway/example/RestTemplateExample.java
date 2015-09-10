package com.panasonic.gateway.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Order(2)
@Component
public class RestTemplateExample implements CommandLineRunner {
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public void run(String... strings) throws Exception {
		// use the "smart" Eureka-aware RestTemplate
//		ParameterizedTypeReference<List<Portal>> responseType = new ParameterizedTypeReference<List<Portal>>() {};
//
//		ResponseEntity<List<Portal>> exchange = this.restTemplate.exchange(
//				"http://portal-service/{userId}/bookmarks", HttpMethod.GET,
//				null, responseType, (Object) "pwebb");
//
//		exchange.getBody().forEach(System.out::println);
	}
}