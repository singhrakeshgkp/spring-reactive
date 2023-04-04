package com.reactive.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.reactive.model.Book;

public interface BookRepo extends ReactiveCrudRepository<Book, Integer> {

}
