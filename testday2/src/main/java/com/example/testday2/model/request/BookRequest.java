package com.example.testday2.model.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookRequest {
    private String title;
    private String author;
    private int yearPublished;
    private List<Long> categoryIds;
}
