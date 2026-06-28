package com.aravind.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aravind.model.Product;
import com.aravind.repo.ProductRepo;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo repo;
	
	@Override
	public Product addProduct(Product product) {
		repo.save(product);
		return product;
	}

	@Override
	public List<Product> getAllProducts() {
		return repo.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		Optional<Product> res = repo.findById(id);
		if(res.isPresent()) {
			return res.get();
		}
		return null;
	}

}
