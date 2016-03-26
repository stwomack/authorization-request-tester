package io.pivotal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class AuthorizationRequestWorkerApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(AuthorizationRequestWorkerApplication.class, args);
	}
}
