package com.op.service.security.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

// https://spring.io/blog/2015/02/03/sso-with-oauth2-angular-js-and-spring-security-part-v

/**
 * Retrieve an access token using:
 * {@code curl -X POST -vu acme:acmesecret http://localhost:9999/uaa/oauth/token -H "Accept: application/json" -d "password=spring&username=jlong&grant_type=password&scope=openid&client_secret=acmesecret&client_id=acme" }
 * 
 * Then, send the access token to an OAuth2 secured REST resource using:
 * {@code curl http://localhost:9000/hi -H "Authorization: Bearer _INSERT TOKEN_"}
 *
 * @author Dave Syer (THANK YOU DAVE!)
 * @author Josh Long
 */
@SpringBootApplication
@EnableResourceServer
@EnableEurekaClient
public class SsoAuthServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(SsoAuthServerApplication.class, args);
	}
}
