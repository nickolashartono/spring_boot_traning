package com.example.testday1.exception;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException (String errorMessage) {
        super(errorMessage);
    }
}
