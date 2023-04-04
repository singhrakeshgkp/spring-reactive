package com.reactive.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.model.Book;

import reactor.core.publisher.Flux;

@RestController
public class BookController {

	//@Autowired
	//private  BookService bookService;
	
	@GetMapping(value = "/books", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Book> getBooks(){
	
		return null; //bookService.getBooks();
	}
	
}
