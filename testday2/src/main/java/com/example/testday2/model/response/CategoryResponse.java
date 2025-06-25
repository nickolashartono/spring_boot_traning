package com.example.testday2.model.response;

import java.util.List;

import com.example.testday2.model.db.Book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CategoryResponse {
    private Long id;
    private String name;
    private String description;
    private List<Book.BookInnerSchema> books;
}
