package com.chandan.cache.rest.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;
import org.springframework.cache.interceptor.CacheResolver;

public class CacheResolverSwitch implements CacheResolver{

	@Autowired
	@Qualifier("inmemoryCacheManager")
	private CacheManager inmemoryCacheManager;
	
	@Autowired
	@Qualifier("dummyCacheManager")
	private CacheManager dummyCacheManager;
	
	
	@Override
	public Collection<? extends Cache> resolveCaches(CacheOperationInvocationContext<?> context) {
		 
		Class<?> returnType = context.getMethod().getReturnType();

		/*
		 * if (BusinessObjectA.class.equals(returnType)) { return
		 * Arrays.asList(cacheManagerA.getCache(returnType.getSimpleName())); } else if
		 * (BusinessObjectB.class.equals(returnType)) { return
		 * Arrays.asList(cacheManagerB.getCache(returnType.getSimpleName())); }
		 */

		return null;
	}

}
