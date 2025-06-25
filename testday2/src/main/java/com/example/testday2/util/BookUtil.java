package com.example.testday2.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.testday2.model.db.Book;
import com.example.testday2.model.db.Category;
import com.example.testday2.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BookUtil {
    private final BookRepository bookRepository;
    private final CategoryUtil categoryUtil;

    public Book createBook(String title, String author, int yearPublished, List<Long> categoryIds) {
        List<Category> listCategory = new ArrayList<>();
        for (Long categoryId : categoryIds) {
            listCategory.add(categoryUtil.getCategoryById(categoryId));
        }
        Book newBook = bookRepository.save(Book.builder()
                                    .title(title)
                                    .author(author)
                                    .yearPublished(yearPublished)
                                    .categories(listCategory)
                                    .build());
        return newBook;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).get();
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
