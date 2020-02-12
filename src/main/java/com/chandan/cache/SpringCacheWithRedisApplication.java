package com.chandan.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;

@SpringBootApplication
//@SpringBootApplication(exclude = { RedisAutoConfiguration.class } )
public class SpringCacheWithRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCacheWithRedisApplication.class, args);
	}

}
