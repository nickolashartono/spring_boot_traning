package com.example.testday2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testday2.model.request.BookRequest;
import com.example.testday2.service.BookService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/")
    public String getAllBooks() {
        return bookService.getAllBooks().toString();
    }

    @PostMapping("/")
    public String createBook(@RequestBody BookRequest bookRequest) {
        return bookService.createBook(bookRequest.getTitle(), bookRequest.getAuthor(), bookRequest.getYearPublished(), bookRequest.getCategoryIds()).toString();
    }

    @GetMapping("/{id}")
    public String getBookById(@PathVariable Long id) {
        return bookService.getBookById(id).toString();
    }
    
    @DeleteMapping("/{id}")
    public String deleteBookById(@PathVariable Long id) {
        return bookService.deleteBookById(id).toString();
    }
    
}
