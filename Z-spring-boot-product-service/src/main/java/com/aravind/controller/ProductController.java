package com.aravind.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aravind.model.Product;
import com.aravind.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService service;

	@GetMapping("/hello")
	public String greet() {
		return "hello hi";
	}
	
	@PostMapping(value = "/saveproduct",produces = "application/json",consumes = "application/json")
	public ResponseEntity<Product> save(@RequestBody Product product){
		Product prod = service.addProduct(product);
		return new ResponseEntity<Product>(prod,HttpStatus.CREATED);
	}
	
	@GetMapping("/getprod/{id}")
	public Product getById(@PathVariable Integer id) {
		return service.getProductById(id);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> list = service.getAllProducts();
		return new ResponseEntity<List<Product>>(list,HttpStatus.FOUND);
	}
}
