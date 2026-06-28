package com.aravind.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aravind.binding.Rate;

@FeignClient(name = "SPRING-BOOT-MICROSERVICE-WITH-CIRCUITBREAKER-PROVIDER")
public interface RateFeign {
	
	@GetMapping(value="/getRate")
	 List<Rate> getRate(@RequestParam String type);
}
