package com.example.testday2.model.db;

import java.util.ArrayList;
import java.util.List;

import com.example.testday2.model.response.BookResponse;
import com.example.testday2.model.response.CategoryResponse;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private int yearPublished;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_category", 
                joinColumns = @JoinColumn(name = "book_id"), 
                inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    public BookResponse toBookResponse() {
        try {
            List<Category.CategoryInnerSchema> listCategory = new ArrayList<>();
            if (categories != null) {
                for (Category category : categories) {
                    listCategory.add(new Category.CategoryInnerSchema(category.getId(),category.getName(),category.getDescription()));
                }
            }
            return new BookResponse(id, title, author, yearPublished, listCategory);
        } catch (Exception e) {
            return null;
        }
    }
    
    @Data
    @Getter
    @Setter
    @AllArgsConstructor
    public static class BookInnerSchema {
        private Long id;
        private String title;
        private String author;
        private int yearPublished;
    }
}
