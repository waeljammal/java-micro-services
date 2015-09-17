package com.op.service.security.sso;

import com.op.service.security.sso.settings.Settings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableAutoConfiguration
@SpringBootApplication
@EnableResourceServer
@EnableEurekaClient
@EnableConfigurationProperties(Settings.class)
public class SsoAuthServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(SsoAuthServerApplication.class, args);
	}
}