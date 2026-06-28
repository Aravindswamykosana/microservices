package com.aravind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ZSpringBootEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZSpringBootEurekaServerApplication.class, args);
	}

}
