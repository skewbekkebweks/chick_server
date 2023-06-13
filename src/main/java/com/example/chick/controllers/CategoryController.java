package com.example.chick.controllers;

import com.example.chick.entity.Category;
import com.example.chick.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/category")
    public ArrayList<Category> getCategories() {
        return (ArrayList<Category>) categoryRepository.findAll();
    }

}
