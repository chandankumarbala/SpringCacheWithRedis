package com.chandan.cache.bean;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String md5;

	private String id;
	private String title;
	private String volumeinfo;
	private String author;
	private String publisher;
	private String language;
	private String googlebookid;
	private String coverurl;
}
