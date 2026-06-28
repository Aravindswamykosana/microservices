package com.aravind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableEurekaServer
public class SpringBootMicroserviceEurekaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext cntxt = SpringApplication.run(SpringBootMicroserviceEurekaApplication.class, args);
//		String[] data = cntxt.getBeanDefinitionNames();
//		for(String s:data) {
//			System.out.println(s);
//		}
	}

}
