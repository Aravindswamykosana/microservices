package com.aravind.controller;
import com.aravind.configuration.RedisConfig;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aravind.binding.Country;

@RestController
public class RedisController {

    private final RedisConfig redisConfig;

	HashOperations<String, Integer, Country> opsForHash=null;
	
	public RedisController(RedisTemplate<String, Country> redis, RedisConfig redisConfig) {
		 this.opsForHash = redis.opsForHash();
		 this.redisConfig = redisConfig;
	}
	
	@PostMapping(value="/savecountry",
				produces = "application/json",
				consumes = "application/json"
			)
	public String addCountry(@RequestBody Country country) {
		opsForHash.put("countries",country.getSlno(),country);
		return "country added succesfully in redis server..!";
	}
	
	@GetMapping(value="/getcountry",produces = "application/json")
	public Collection<Country> getCountries() {
		Map<Integer, Country> data = opsForHash.entries("countries");
		Collection<Country> value = data.values();
		return value;
	}
}
