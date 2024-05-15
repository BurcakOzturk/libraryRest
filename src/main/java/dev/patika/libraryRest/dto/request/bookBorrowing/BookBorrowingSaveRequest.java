package dev.patika.libraryRest.dto.request.bookBorrowing;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookBorrowingSaveRequest {

    @NotNull
    private String name;

    @NotNull
    private LocalDate borrowing_date;

    @NotNull
    private LocalDate return_date;

    @NotNull
    private int book_borrow_id;

}
