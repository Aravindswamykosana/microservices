package com.aravind.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "product-service")
public interface ProductFeign {
	
	@GetMapping("/getprod/{id}")
	public ProductDto getById(@PathVariable Integer id);
}
