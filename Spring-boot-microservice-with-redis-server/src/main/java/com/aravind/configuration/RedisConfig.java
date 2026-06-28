package com.aravind.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.aravind.binding.Country;

@Configuration
public class RedisConfig {
	
	@Bean
	public JedisConnectionFactory jedis() {
		JedisConnectionFactory factory=new JedisConnectionFactory();
		//no need to set the redis properties bcoz server running in our local
		return factory;
	}
	
	@Bean
	public RedisTemplate<String,Country> redis(){
		RedisTemplate<String,Country> rediss=new RedisTemplate<String,Country>();
		rediss.setConnectionFactory(jedis());
		return rediss;
	}
}
