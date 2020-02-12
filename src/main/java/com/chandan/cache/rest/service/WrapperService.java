package com.chandan.cache.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.chandan.cache.bean.Book;
import com.chandan.cache.bean.BookEntity;

@Service
public class WrapperService {
	
	@Autowired
	private ExternalService externalFacingService;
	
	
	@Cacheable(value = "BooksInmemoryCache", key="#bookId",cacheManager = "inmemoryCacheManager")
	public Book getBookFromId(String bookId) {
		return externalFacingService.getBookById(bookId);
	}
	
	
	@Cacheable(value = "BooksRedisCache", key="#bookId",cacheManager = "reidsCacheManager")
	public BookEntity getBookFromMd5(String bookId) {
		return externalFacingService.getBookByMd5(bookId);
	}
	

}
