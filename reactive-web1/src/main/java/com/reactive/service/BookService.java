package com.reactive.service;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactive.model.Book;
import com.reactive.repository.BookRepo;

import reactor.core.publisher.Flux;


@Service
public class BookService {
	
	//@Autowired
	//private  BookRepo bookRepo;
	
	public Flux<Book> getBooks(){
		
		return null;//bookRepo.findAll().delayElements(Duration.ofSeconds(5));
	}

}
