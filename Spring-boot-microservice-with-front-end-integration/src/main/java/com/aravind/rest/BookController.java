package com.aravind.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aravind.model.Book1;
import com.aravind.service.BookService;

@RestController
@CrossOrigin
public class BookController {

	@Autowired
	private BookService service;
	
	@PostMapping("/savebook")
	public ResponseEntity<Book1> save(@RequestBody Book1 book){
		Book1 data = service.saveBook(book);
		return new ResponseEntity<Book1>(data,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/books")
	public List<Book1> getBooks(){
		return service.getBooks();
	}
}
