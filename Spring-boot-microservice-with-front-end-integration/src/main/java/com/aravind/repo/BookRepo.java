package com.aravind.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aravind.model.Book1;

public interface BookRepo extends JpaRepository<Book1, Integer>{

}
