package com.aravind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootMicroserviceWithSpringShedularApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroserviceWithSpringShedularApplication.class, args);
	}

}
