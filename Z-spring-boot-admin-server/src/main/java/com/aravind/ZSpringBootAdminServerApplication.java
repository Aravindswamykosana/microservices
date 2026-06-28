package com.aravind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class ZSpringBootAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZSpringBootAdminServerApplication.class, args);
	}

}
