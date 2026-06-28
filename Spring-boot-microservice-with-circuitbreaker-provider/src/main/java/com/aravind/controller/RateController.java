package com.aravind.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aravind.model.Rate;
import com.aravind.service.RateService;

@RestController
public class RateController {
	
	@Autowired
	private RateService service;
	
	@PostMapping(value="/saveRate",produces = "application/json",consumes = "application/json")
	public ResponseEntity<Rate> save(@RequestBody Rate rate){
		Rate data = service .saveRate(rate);
		return new ResponseEntity<Rate>(data,HttpStatus.CREATED);
	}
	
	@GetMapping("/getRate")
	public List<Rate> getRateByType(@RequestParam String type){
		return service.getRate(type);
	}
}
