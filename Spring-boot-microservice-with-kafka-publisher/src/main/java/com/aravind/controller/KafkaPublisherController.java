package com.aravind.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aravind.model.Customer;
import com.aravind.service.KafkaService;

@RestController
public class KafkaPublisherController {
	
	@Autowired
	private KafkaService service;
	
	@PostMapping(value = "/savecustomer",
				 consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
				 produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
			)
	public ResponseEntity<String> addCustomers(@RequestBody List<Customer> customers){
		String cust = service.addCustomers(customers);
		return new ResponseEntity<String>(cust,HttpStatus.CREATED);
	}
}
