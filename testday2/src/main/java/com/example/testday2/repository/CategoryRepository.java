package com.example.testday2.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testday2.model.db.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}
