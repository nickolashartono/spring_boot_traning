package com.example.testday1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testday1.util.BookUtil;

@Service
public class BookService {
    @Autowired
    BookUtil bookUtil;

    public String getAllBooks() {
        return bookUtil.getAllBooks().toString();
    }

    public String addNewBook(String author, String title) {
        return bookUtil.addNewBook(author, title);
    }

    public String getBookById(int id) {
        return bookUtil.getBookById(id).toString();
    }

    public String deleteBookById(int id) {
        return bookUtil.deleteBookById(id);
    }
}
