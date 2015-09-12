package com.op.service.portal;

import com.op.service.portal.entity.Portal;
import com.op.service.portal.repository.PortalRepository;
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
	public CommandLineRunner init(PortalRepository portalRepository) {
        return args -> {
            portalRepository.deleteAll();

            Arrays.asList("portal1", "portal2").forEach(n -> {
                Portal bm = new Portal(n, 1L);
                portalRepository.save(bm);
            });
        };
	}

	public static void main(String[] args) {
		SpringApplication.run(PortalServiceApplication.class, args);
	}
}