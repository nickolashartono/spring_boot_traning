package com.example.testday2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testday2.model.request.CategoryRequest;
import com.example.testday2.service.CategoryService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/")
    public String addCategory(@RequestBody CategoryRequest categoryRequest) {
        return categoryService.addCategory(categoryRequest.getName(), categoryRequest.getDescription()).toString();
    }
    
    @GetMapping("/")
    public String getAllCategories() {
        return categoryService.getAllCategories().toString();
    }
}
