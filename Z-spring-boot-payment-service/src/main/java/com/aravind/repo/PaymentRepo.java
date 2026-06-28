package com.aravind.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aravind.model.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer>{

}
