package com.example.bookstore.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    List<Category> findByName(String name);

    @Override
    Iterable<Category> findAll();
}