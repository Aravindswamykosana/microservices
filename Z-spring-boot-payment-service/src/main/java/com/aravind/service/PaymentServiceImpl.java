package com.aravind.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aravind.feign.PaymentDto;
import com.aravind.feign.PaymentFeign;
import com.aravind.model.Payment;
import com.aravind.repo.PaymentRepo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class PaymentServiceImpl implements PaymentService{

	public static final String SERVICE_NAME="productService";
	
	@Autowired
	private PaymentRepo repo;
	
	@Autowired
	private PaymentFeign feign;
	
	@Override
	public List<Payment> getAllPayments() {
		return repo.findAll();
	}

	@Override
	@CircuitBreaker(name = SERVICE_NAME,fallbackMethod = "fallBackMethod")
	public Payment doPayment(Payment payment) {
	    payment.setTimestamp(LocalDateTime.now());
	    
	    PaymentDto order = feign.getById(payment.getOrderId());
	    if (order != null) {
	        payment.setMoney(order.getPrice());
	        return repo.save(payment);
	    } else {
	        throw new RuntimeException("Order ID not found: " + payment.getOrderId());
	    }
	}
	
	public Payment fallBackMethod(Payment payment, Throwable ex) {
	    Payment fallback = new Payment();
	    fallback.setOrderId(payment.getOrderId());
	    fallback.setMoney(0.0);
	    fallback.setPaymentType("FAILED");
	    fallback.setTimestamp(LocalDateTime.now());
	    System.out.println("Fallback due to: " + ex.getMessage());
	    return fallback;
	}


}
