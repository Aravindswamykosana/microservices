package com.aravind.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aravind.service.WelcomeService;

@RestController
public class WelcomeRest {

	@Autowired
	private WelcomeService service;
	
	@GetMapping("/welcome")
	public ResponseEntity<String> welcome(){
		 String msg = service.welcomeMsg();
		 return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@GetMapping("/greet")
	public ResponseEntity<String> greet(){
		 String msg = service.greetMsg();
		 return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
}
