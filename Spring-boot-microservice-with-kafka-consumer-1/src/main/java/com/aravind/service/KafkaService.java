package com.aravind.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.aravind.model.Customer;
import com.aravind.util.KafkaConstants;

@Service
public class KafkaService {

	private List<Customer> lastReceivedCustomer=new ArrayList<>();

//	@KafkaListener(topics = KafkaConstants.TOPIC_NAME, groupId = KafkaConstants.GROUP_ID)
//	public Customer listener(Customer c) {
//		System.out.println("***Msg recieved fron kafka Topic::" + c);
//		return c;
//	}
	
	
	
	@KafkaListener(topics = KafkaConstants.TOPIC_NAME, groupId = KafkaConstants.GROUP_ID)
	public void listener(Customer c) {
        System.out.println("***Msg received from Kafka Topic::" + c);
        lastReceivedCustomer.add(c);
    }

	public List<Customer> getLastReceivedCustomer() {
		return lastReceivedCustomer;
	}

//	public void setLastReceivedCustomer(List<Customer> lastReceivedCustomer) {
//		this.lastReceivedCustomer = lastReceivedCustomer;
//	}
}
