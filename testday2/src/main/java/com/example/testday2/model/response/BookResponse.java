package com.example.testday2.model.response;

import java.util.List;

import com.example.testday2.model.db.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class BookResponse {
    private Long id;
    private String title;
    private String author;
    private int yearPublished;
    private List<Category.CategoryInnerSchema> categories;
}
