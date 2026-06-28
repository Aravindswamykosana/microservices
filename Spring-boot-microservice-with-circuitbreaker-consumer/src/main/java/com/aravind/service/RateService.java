package com.aravind.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aravind.binding.Rate;
import com.aravind.feign.RateFeign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class RateService {
	public static final String SERVICE_NAME="loan-service";
	
	@Autowired
	private RateFeign feign;
	
	@CircuitBreaker(name = SERVICE_NAME,fallbackMethod = "fallBackMethod")
	public List<Rate> getAllRates(String type){
		System.out.println("***original method called****");
		List<Rate> rates = feign.getRate(type);
		return rates;
	}
	
	public List<Rate> fallBackMethod(String type, Throwable t) {
	    System.out.println("***fallback method called due to: " + t.getMessage() + "***");
	    List<Rate> fallbackRates = new ArrayList<>();
	    Rate rate = new Rate();
	    rate.setType("default");
	    rate.setInterest(0.0);
	    fallbackRates.add(rate);
	    return fallbackRates;
	}
}
