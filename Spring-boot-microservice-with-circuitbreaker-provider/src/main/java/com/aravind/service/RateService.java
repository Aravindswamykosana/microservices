package com.aravind.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aravind.model.Rate;
import com.aravind.repo.RateRepo;

@Service
public class RateService {
	
	@Autowired
	private RateRepo repo;
	
	public Rate saveRate(Rate rate) {
		return repo.save(rate);
	}
	
	public List<Rate> getRate(String type) {
		List<Rate> data = repo.findByType(type);
		if(data!=null) {
			return data;
		}
		else {
			return null;
		}
	}
}
