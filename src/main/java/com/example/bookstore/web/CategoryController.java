package com.example.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.bookstore.model.Category;
import com.example.bookstore.model.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository CategoryRepository;

    @GetMapping("/categorylist")
    public String categoryList(Model model) {
        Iterable<Category> categoryIterable = CategoryRepository.findAll();
        List<Category> categories = new ArrayList<>();
        categoryIterable.forEach(categories::add);
        model.addAttribute("categories", categories);
        return "categorylist";
    }

    @GetMapping("/addcategory")
    public String showAddCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory";
    }

    @PostMapping("/addcategory")
    public String addCategory(Category category) {
        CategoryRepository.save(category);
        return "redirect:/categorylist";
    }
}