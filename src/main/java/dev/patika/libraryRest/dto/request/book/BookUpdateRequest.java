package dev.patika.libraryRest.dto.request.book;

import dev.patika.libraryRest.entities.Category;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookUpdateRequest {
    @Positive(message = "ID değeri pozitif sayı olmak zorunda")
    private int id;

    @NotNull(message = "Kategori ismi boş veya null olamaz")
    private String name;

    @NotNull
    private int publicationYear;

    private int stock;

    //@NotNull
    private int bookAuthorId;

   // @NotNull
    private List<Category> categoryList;

   // @NotNull
    private int bookPublisherId;
}
