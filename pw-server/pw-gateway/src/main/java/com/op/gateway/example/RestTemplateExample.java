package com.op.gateway.example;

import com.op.gateway.to.Portal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

//@Order(2)
//@Component
public class RestTemplateExample implements CommandLineRunner {
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public void run(String... strings) throws Exception {
		// use the "smart" Eureka-aware RestTemplate
		ParameterizedTypeReference<List<Portal>> responseType = new ParameterizedTypeReference<List<Portal>>() {};

		ResponseEntity<List<Portal>> exchange = this.restTemplate.exchange(
				"http://portal-service/{domainId}", HttpMethod.GET,
				null, responseType, 1);

		exchange.getBody().forEach(System.out::println);
	}
}