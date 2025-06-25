package com.example.testday2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testday2.model.db.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
}
