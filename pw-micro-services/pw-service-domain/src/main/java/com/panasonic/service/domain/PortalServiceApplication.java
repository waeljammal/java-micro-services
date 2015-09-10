package com.panasonic.service.domain;

import com.panasonic.service.domain.entity.Domain;
import com.panasonic.service.domain.repository.DomainRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
@EnableEurekaClient
public class PortalServiceApplication {

	@Bean
	public CommandLineRunner init(DomainRepository portalRepository) {
        return args -> {
            portalRepository.deleteAll();

            Arrays.asList("portal-works").forEach(n -> {
                Domain bm = new Domain(n);
                portalRepository.save(bm);
            });
        };
	}

	public static void main(String[] args) {
		SpringApplication.run(PortalServiceApplication.class, args);
	}

}
