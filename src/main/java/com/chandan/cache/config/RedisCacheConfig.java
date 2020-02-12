package com.chandan.cache.config;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.scheduling.annotation.Scheduled;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class RedisCacheConfig {

	@Value("${redis.cache.names}")
	private Set<String> redisCacheNames;
	
	@Autowired
	private RedisConnectionFactory redisConnections;
	
	@Bean("reidsCacheManager")
    public CacheManager cacheManager() {
		RedisCacheManager rcm = RedisCacheManager.builder(redisConnections).initialCacheNames(redisCacheNames).build();
	    rcm.setTransactionAware(true);
	    return rcm;
    }
	
	
	@Scheduled(fixedDelay = 40000)
	@CacheEvict(value = {"BooksRedisCache"},allEntries = true,cacheManager = "reidsCacheManager")
	public void scheculedEvictCache() {
		log.info("Cache eviction is done for :: BooksRedisCache");
	}
}
