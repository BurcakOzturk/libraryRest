package dev.patika.libraryRest.dto.request.bookBorrowing;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowingUpdateRequest {
    @Positive(message = "ID değeri pozitif sayı olmak zorunda")
    private int id;

    @NotNull(message = "Kategori ismi boş veya null olamaz")
    private String name;

    @NotNull
    private LocalDate borrowing_date;

    @NotNull
    private LocalDate return_date;

    @NotNull
    private int book_borrow_id;
}
