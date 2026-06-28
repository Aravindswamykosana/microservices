package com.aravind.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.aravind.model.Customer;
import com.aravind.util.KafkaConstants;

@Service
public class KafkaService {
	
	@Autowired
	private KafkaTemplate<String,Customer> kafkaTemplate;
	
	public String addCustomers(List<Customer> customers) {
		if(!customers.isEmpty()) {
			for(Customer c:customers) {
				kafkaTemplate.send(KafkaConstants.TOPIC_NAME,c);
				System.out.println("*** Msg from Publisher ***"+c);
			}
			return "messages are added in kafka queue succesfully..!";
		}
		return "customers are empty not possible to add into kafka queue..!";
	}
}
