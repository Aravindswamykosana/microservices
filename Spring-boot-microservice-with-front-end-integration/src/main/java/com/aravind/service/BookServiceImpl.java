package com.aravind.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aravind.model.Book1;
import com.aravind.repo.BookRepo;
@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepo repo;
	
	@Override
	public Book1 saveBook(Book1 book) {
		repo.save(book);
		return book;
	}

	@Override
	public List<Book1> getBooks() {
		return repo.findAll();
	}

}
