package com.chandan.cache.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.chandan.cache.bean.Book;
import com.chandan.cache.bean.BookEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ExternalService {

	@Autowired
	private RestTemplate restCaller;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Value("${onlinedealer.url}")
	private String extUrl;
	
	public Book getBookById(String id) {
		log.info("Invoking external server :: {}",extUrl);
		String url = new StringBuffer(extUrl).append("?fields=title,volumeinfo,author,publisher,language,googlebookid,coverurl,md5,id")
						.append("&ids=").append(id).toString();
		String bookList = restCaller.getForObject(url, String.class);
		try {
			Book[] books=mapper.readValue(bookList, Book[].class);
			return books[0];
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	
	public BookEntity getBookByMd5(String id) {
		log.info("Invoking external server :: {}",extUrl);
		String url = new StringBuffer(extUrl).append("?fields=title,volumeinfo,author,publisher,language,googlebookid,coverurl,md5,id")
						.append("&ids=").append(id).toString();
		String bookList = restCaller.getForObject(url, String.class);
		try {
			BookEntity[] books=mapper.readValue(bookList, BookEntity[].class);
			return books[0];
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
 
}