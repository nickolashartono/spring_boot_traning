package com.example.testday1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testday1.model.request.BookRequest;
import com.example.testday1.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    BookService bookService;
    
    @GetMapping("/")
    public ResponseEntity<?> getAllBooks() {
        String resp = bookService.getAllBooks();
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
    
    @PostMapping("/")
    public ResponseEntity<?> addNewBook(@RequestBody BookRequest bookRequest) {
        String resp = bookService.addNewBook(bookRequest.getTitle(), bookRequest.getAuthor());
        return new ResponseEntity<>(resp, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable int id) {
        String resp = bookService.getBookById(id);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable int id) {
        String resp = bookService.deleteBookById(id);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
