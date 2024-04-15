package com.example.bookstore;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookRepository;
import com.example.bookstore.model.Category;
import com.example.bookstore.model.CategoryRepository;
import com.example.bookstore.model.User;
import com.example.bookstore.model.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BookstoreTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testBookRepository() {
        Book book = new Book("Kirja 1", "Jukka", "2002", "33498290", "30", null);
        bookRepository.save(book);

        Optional<Book> foundBook = bookRepository.findById(book.getId());
        assertThat(foundBook).isPresent();

        bookRepository.delete(book);
        assertThat(bookRepository.findById(book.getId())).isEmpty();
    }

    @Test
    public void testCategoryRepository() {
        Category category = new Category("Fiction");
        categoryRepository.save(category);

        List<Category> foundCategory = categoryRepository.findByName("Fiction");
        assertThat(foundCategory).isNotEmpty();

        categoryRepository.delete(category);
        assertThat(categoryRepository.findByName("Fiction")).isEmpty();
    }

    @Test
    public void testUserRepository() {
        User user = new User("USER", "test", "test@gmail.com", "USER");
        userRepository.save(user);

        User foundUser = userRepository.findByUsername("USER");
        assertThat(foundUser).isNotNull();

        userRepository.delete(user);
        assertThat(userRepository.findByUsername("USER")).isNull();
    }
}
