package com.example.testday2.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.testday2.model.db.Category;
import com.example.testday2.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CategoryUtil {
    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).get();
    }

    public Category createCategory(String name, String description) {
        return categoryRepository.save(Category.builder().name(name).description(description).build());
    }

    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }
}
