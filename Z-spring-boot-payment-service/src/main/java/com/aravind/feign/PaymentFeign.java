package com.aravind.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="order-service")
public interface PaymentFeign {

	@GetMapping("/getid/{id}")
	public PaymentDto getById(@PathVariable Integer id);
}
