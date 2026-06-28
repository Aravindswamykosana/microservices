package com.aravind.service;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {
	
	public String welcomeMsg() {
		return "hi hello welocme to our app..😎😎";
	}
	
	public String greetMsg() {
		return "good evening..!😁😁";
	}
}
