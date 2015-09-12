package demo;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.security.oauth2.resource.EnableOAuth2Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootApplication
@EnableOAuth2Resource
@RestController
@EnableEurekaClient
@Log
public class SsoResourceApplication {

	@RequestMapping("/hello-world")
	public Map<String, Object> hi(Principal principal) {
        log.info("Received request from " + principal.getName());
		Map<String, Object> result = new HashMap<>();
		result.put("id", UUID.randomUUID().toString());
		result.put("content", "Hello, world!");
		return result;
	}

	public static void main(String[] args) {
		SpringApplication.run(SsoResourceApplication.class, args);
	}
}