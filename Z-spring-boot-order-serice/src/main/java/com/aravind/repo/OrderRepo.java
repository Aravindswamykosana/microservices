package com.aravind.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aravind.model.Order;

public interface OrderRepo extends JpaRepository<Order, Integer>{

}
