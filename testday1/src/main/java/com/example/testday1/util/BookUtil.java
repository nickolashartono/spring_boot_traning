package com.example.testday1.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.testday1.exception.BookNotFoundException;
import com.example.testday1.model.Book;

@Component
public class BookUtil {
    List<Book> listBook;
    int idCounter;

    public BookUtil() {
        listBook = new ArrayList<>();
        idCounter = 0;
    }

    public List<Book> getAllBooks() {
        return listBook;
    }

    public String addNewBook(String author, String title) {
        Book newBook = new Book(idCounter++, title, author);
        listBook.add(newBook);
        return "Succesfully Created New Book with Detail: " + newBook.toString();
    }

    public Book getBookById(int id) {
        try {
            return listBook.stream().filter(book -> book.getId() == id).findFirst().get();
        } catch (Exception ex) {
            throw new BookNotFoundException("Book Not Found with ID: " + id);
        }
    }

    public String deleteBookById(int id) {
        try {
            Book bookResult = listBook.stream().filter(book -> book.getId() == id).findFirst().get();
            listBook.remove(bookResult);
            return "Succesfully Deleted Book with Detail: " + bookResult.toString();
        } catch (Exception ex) {
            throw new BookNotFoundException("Book Not Found with ID: " + id);
        }
    }
}
