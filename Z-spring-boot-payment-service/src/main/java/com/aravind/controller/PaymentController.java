package com.aravind.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aravind.model.Payment;
import com.aravind.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService service;
	
	@GetMapping("/getall")
	public List<Payment> getAllPayments(){
		return service.getAllPayments();
	}
	
	@PostMapping("/payment")
	public ResponseEntity<Payment> doPayment(@RequestBody Payment payment){
		Payment pay = service.doPayment(payment);
		return new ResponseEntity<Payment>(pay,HttpStatus.ACCEPTED);
	}
}
