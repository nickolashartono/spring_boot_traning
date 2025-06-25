package com.example.testday2.model.db;

import java.util.ArrayList;
import java.util.List;

import com.example.testday2.model.db.Book.BookInnerSchema;
import com.example.testday2.model.response.CategoryResponse;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @ManyToMany(mappedBy = "categories")
    private List<Book> books;

    public CategoryResponse toCategoryResponse() {
        try {
            List<Book.BookInnerSchema> listBook = new ArrayList<>();
            if (books != null) {
                for (Book book : books) {
                    listBook.add(new BookInnerSchema(book.getId(), book.getTitle(), book.getAuthor(), book.getYearPublished()));
                }
            }
            return new CategoryResponse(id, name, description, listBook);
        } catch (Exception e) {
            return null;
        }
    }

    @Data
    @Getter
    @Setter
    @AllArgsConstructor
    public static class CategoryInnerSchema {
        private Long id;
        private String name;
        private String description;
    }
}
