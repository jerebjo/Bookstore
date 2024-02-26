package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book book1 = new Book("kirja1", "jukka", "2002", "33498290", "30");
			Book book2 = new Book("kirja2", "jari", "2006", "33499402", "20");
			// Your code...add some demo data to db
			repository.save(book1);
			repository.save(book2);
		};
	}
}
