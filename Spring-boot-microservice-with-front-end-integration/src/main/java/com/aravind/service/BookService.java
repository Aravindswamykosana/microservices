package com.aravind.service;

import java.util.List;

import com.aravind.model.Book1;

public interface BookService {
	public Book1 saveBook(Book1 book);
	public List<Book1> getBooks();
}
