package com.example.testday2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.testday2.model.db.Category;
import com.example.testday2.model.response.CategoryResponse;
import com.example.testday2.util.CategoryUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryUtil categoryUtil;

    public CategoryResponse addCategory(String name, String description) {
        return categoryUtil.createCategory(name, description).toCategoryResponse();
    }

    public List<CategoryResponse> getAllCategories() {
        return categoryUtil.getAllCategories().stream().map(Category::toCategoryResponse).toList();
    }
}
