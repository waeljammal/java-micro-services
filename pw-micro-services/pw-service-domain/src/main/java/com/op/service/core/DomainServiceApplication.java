package com.op.service.core;

import com.op.service.core.settings.Settings;
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
