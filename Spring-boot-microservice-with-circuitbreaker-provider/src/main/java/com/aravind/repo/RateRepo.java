package com.aravind.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aravind.model.Rate;

public interface RateRepo extends JpaRepository<Rate, Integer>{
	public abstract List<Rate> findByType(String type);
}
