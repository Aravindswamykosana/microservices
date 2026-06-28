package com.aravind.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aravind.feign.ProductDto;
import com.aravind.feign.ProductFeign;
import com.aravind.model.Order;
import com.aravind.repo.OrderRepo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class OrderServiceImpl implements OrderService{
	
	public static final String SERVICE_NAME="productService";
	
	@Autowired
	private OrderRepo repo;
	
	@Autowired
	private ProductFeign feign;

	@Override
	public List<Order> getAllOrders() {
		return repo.findAll();
	}
	
	@Override
	@CircuitBreaker(name = SERVICE_NAME,fallbackMethod = "fallBackMethod")
	public Order placeOrder(Integer id, Integer quantity) {
	    ProductDto prod = feign.getById(id);
	    Order order = new Order();
	    BeanUtils.copyProperties(prod, order);
	    order.setQuantity(quantity); 
	    repo.save(order);
	    return order;
	}
	
	public Order fallBackMethod(Integer id, Integer quantity, Throwable ex) {
		System.err.println("Fallback triggered due to: " + ex.getMessage());
	    return new Order(null, id, "Unavailable..!", 0.0, quantity);
	}

	@Override
	public Order getById(int id) {
		Optional<Order> res = repo.findById(id);
		if(res.isPresent()) {
			return res.get();
		}
		return null;
	}



}
