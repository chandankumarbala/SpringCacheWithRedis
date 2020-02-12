package com.chandan.cache.config;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.SimpleCacheResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableCaching
@EnableScheduling
//@CacheConfig(cacheNames = {"BooksCache"})
@Slf4j
public class InmemoryCacheConfig {

	@Value("${inmemory.cache.names}")
	private String[] inmoryCacheNames;
	
	
	@Bean("inmemoryCacheManager")
	@Primary
    public CacheManager inmemoryCacheManager() {
        return new ConcurrentMapCacheManager(inmoryCacheNames);
    }
	
	
	@Scheduled(fixedDelay = 40000)
	@CacheEvict(value = {"BooksInmemoryCache"},allEntries = true,cacheManager = "inmemoryCacheManager")
	public void scheculedEvictCache() {
		log.info("Cache eviction is done for :: BooksInmemoryCache");
	}
	
	
	
	
	
	
	
}
