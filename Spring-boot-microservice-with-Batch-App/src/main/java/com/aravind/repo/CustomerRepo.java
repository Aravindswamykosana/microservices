package com.aravind.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aravind.entity.Customer;

public interface CustomerRepo  extends JpaRepository<Customer, Integer>{

}
