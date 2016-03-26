package io.pivotal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class AuthorizationRequestTesterApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(AuthorizationRequestTesterApplication.class, args);
	}
}
