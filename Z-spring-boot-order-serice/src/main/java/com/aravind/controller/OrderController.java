package com.aravind.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aravind.model.Order;
import com.aravind.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@GetMapping("/getallorders")
	public ResponseEntity<List<Order>> getAll(){
		List<Order> orders = service.getAllOrders();
		return new ResponseEntity<List<Order>>(orders,HttpStatus.FOUND);
	}
	
	@PostMapping("/getorder")
	public Order placeOrder(@RequestParam Integer id,@RequestParam Integer quantity) {
		return service.placeOrder(id, quantity);
	}
	
	@GetMapping("/getid/{id}")
	public Order getById(@PathVariable Integer id) {
		return service.getById(id);
	}
}
