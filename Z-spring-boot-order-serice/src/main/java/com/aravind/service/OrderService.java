package com.aravind.service;

import java.util.List;

import com.aravind.model.Order;

public interface OrderService {
	public List<Order> getAllOrders();
	public Order placeOrder(Integer id, Integer quantity);
	public Order getById(int id);
}
