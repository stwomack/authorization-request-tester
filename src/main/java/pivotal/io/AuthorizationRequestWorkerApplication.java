package pivotal.io;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pivotal.io.service.OutputProcessorTester;

import java.io.IOException;

@SpringBootApplication
public class AuthorizationRequestWorkerApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(AuthorizationRequestWorkerApplication.class, args);
	}
}
