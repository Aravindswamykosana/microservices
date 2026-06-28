package com.aravind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringBootMicroserviceWithConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroserviceWithConfigServerApplication.class, args);
	}
}
