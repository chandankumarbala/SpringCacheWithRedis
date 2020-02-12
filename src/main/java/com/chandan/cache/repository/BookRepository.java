package com.chandan.cache.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chandan.cache.bean.BookEntity;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, String> {

}
