package com.aravind.service;

import java.util.List;

import com.aravind.model.Product;

public interface ProductService {
	public Product addProduct(Product product);
	public List<Product> getAllProducts();
	public Product getProductById(Integer id);
}
