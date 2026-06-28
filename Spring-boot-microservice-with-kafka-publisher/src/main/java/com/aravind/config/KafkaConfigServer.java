package com.aravind.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.aravind.model.Customer;
import com.aravind.util.KafkaConstants;

@Configuration
public class KafkaConfigServer {
	
	@Bean
	public ProducerFactory<String, Customer> producer() {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,KafkaConstants.HOST);
		map.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		map.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(map);
	}
	
	@Bean(name = "kafkaTemplate")
	public KafkaTemplate<String,Customer> template(){
		return new KafkaTemplate<>(producer());
	}
}
