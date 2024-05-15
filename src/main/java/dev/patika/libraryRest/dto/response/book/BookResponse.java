package dev.patika.libraryRest.dto.response.book;

import dev.patika.libraryRest.entities.Category;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {

    private int id;
    private String bookName;
    private int publicationYear;
    private int stock;
    private int bookCategoryId;
    private int bookPublisherId;
    private int bookAuthorId;
    private List<Category> categoryList;

}
