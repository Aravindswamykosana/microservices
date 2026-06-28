package com.aravind.service;

import java.util.List;

import com.aravind.model.Payment;

public interface PaymentService {
	public List<Payment> getAllPayments();
	public Payment doPayment(Payment payment);
}
