package com.aravind.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aravind.binding.Rate;
import com.aravind.service.RateService;

@RestController
public class RateController {
	
	@Autowired
	public RateService service;
	
	@GetMapping("/rate")
	public List<Rate> getRates(@RequestParam String type){
		return service.getAllRates(type);
	}
}
