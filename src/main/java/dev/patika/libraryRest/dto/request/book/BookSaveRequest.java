package dev.patika.libraryRest.dto.request.book;
import dev.patika.libraryRest.entities.Category;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookSaveRequest {

    @NotNull
    private String bookName;

    @NotNull
    private int publicationYear;

    private int stock;

    @NotNull
    private int bookAuthorId;

    @NotNull
    private List<Category> categoryList;

    @NotNull
    private int bookPublisherId;

}
