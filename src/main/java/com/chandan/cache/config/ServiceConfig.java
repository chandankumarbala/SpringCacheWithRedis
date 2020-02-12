package com.chandan.cache.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class ServiceConfig {

	
	@Bean
	public RestTemplate getRest() {
		return new RestTemplate();
	}
	
	
	@Bean
	public ObjectMapper getMapper() {
		return  new ObjectMapper();
	}
	
}
