package dev.patika.libraryRest.dto.response.bookBorrowing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowingResponse {
    private int id;
    private String name;
    private LocalDate borrowing_date;
    private LocalDate return_date;
    private int book_borrow_id;
}
