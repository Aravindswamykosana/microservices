package com.aravind.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aravind.model.Customer;
import com.aravind.service.KafkaService;

@RestController
public class KafkaConsumerController {
	
	@Autowired
	private KafkaService service;

	@GetMapping("/consumer")
	public List<Customer> data() {
		List<Customer> res = service.getLastReceivedCustomer();
		return res;
	}

}
