package com.reactive.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("Book")
public class Book {

	@Id
	private Integer id;
	
	private String name;
	
	
}
