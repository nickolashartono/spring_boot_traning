package com.example.testday1.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Book {
    private int id;
    @NotBlank(message = "Title tidak boleh kosong!")
    private String title;
    @NotBlank(message = "Author tidak boleh kosong!")
    private String author;

    @Override
    public String toString() {
        return "{"+
            "\"Id\": " + id + ", " +
            "\"Title\": \"" + title + "\", " +
            "\"Author\": \"" + author + "\"" +
        "}";
    }
}
