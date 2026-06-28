package com.aravind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootMicroserviceWithCircuitbreakerProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroserviceWithCircuitbreakerProviderApplication.class, args);
	}

}
