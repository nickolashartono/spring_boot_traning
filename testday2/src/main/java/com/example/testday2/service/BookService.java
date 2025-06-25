package com.example.testday2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.testday2.model.db.Book;
import com.example.testday2.model.response.BookResponse;
import com.example.testday2.util.BookUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookUtil bookUtil;

    public BookResponse createBook(String title, String author, int yearPublished, List<Long> categoryIds) {
        return bookUtil.createBook(title, author, yearPublished, categoryIds).toBookResponse();
    }

    public List<BookResponse> getAllBooks() {
        return bookUtil.getAllBooks().stream().map(Book::toBookResponse).toList();
    }

    public BookResponse getBookById(Long id) {
        return bookUtil.getBookById(id).toBookResponse();
    }

    public String deleteBookById(Long id) {
        return "Success Delete Book With ID: " + id;
    }
}
