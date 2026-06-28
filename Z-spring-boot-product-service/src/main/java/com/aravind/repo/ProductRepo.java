package com.aravind.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aravind.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
