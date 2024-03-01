package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookRepository;
import com.example.bookstore.model.Category;
import com.example.bookstore.model.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			// Luodaan muutamia kategorioita ja tallennetaan ne tietokantaan
			Category comic = new Category("Comic");
			Category fantasy = new Category("Fantasy");

			categoryRepository.save(comic);
			categoryRepository.save(fantasy);

			// Luodaan muutamia kirjoja ja asetetaan niille kategoriat
			Book book1 = new Book("Kirja 1", "Jukka", "2002", "33498290", "30", comic);
			Book book2 = new Book("Kirja 2", "Jari", "2006", "33499402", "20", comic);

			bookRepository.save(book1);
			bookRepository.save(book2);

			System.out.println("Kategoriat ja kirjat tallennettu tietokantaan.");
		};
	}
}