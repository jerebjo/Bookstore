package com.example.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.bookstore.web.BookController;
import com.example.bookstore.web.CategoryController;

@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private BookController controller;

	@Autowired
	private CategoryController categoryController;

	@Test
	void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
		assertThat(categoryController).isNotNull();
	}

}
