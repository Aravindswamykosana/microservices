package com.aravind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class SpringBootMicroserviceAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroserviceAdminServerApplication.class, args);
	}

}
