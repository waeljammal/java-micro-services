package com.op.service.domain;

import com.op.service.domain.settings.Settings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigurationProperties(Settings.class)
public class DomainServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(DomainServiceApplication.class, args);
	}
}
