package com.chandan.cache.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.chandan.cache.bean.Book;
import com.chandan.cache.bean.BookEntity;
import com.chandan.cache.rest.service.WrapperService;

@RestController
public class RestService {

	@Autowired
	private WrapperService service;
	
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") String id){
		return new ResponseEntity<Book>(service.getBookFromId(id),HttpStatus.OK);
	}
	
	@GetMapping("/redis/book/{id}")
	public ResponseEntity<BookEntity> getBookFromRedis(@PathVariable("id") String id){
		return new ResponseEntity<BookEntity>(service.getBookFromMd5(id),HttpStatus.OK);
	}
}
