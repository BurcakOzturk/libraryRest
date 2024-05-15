package dev.patika.libraryRest.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name="borrowings")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookBorrowing  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrow_book_id")
    private int id;

    @NotNull
    @Column(name = "borrow_book_name")
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "book_borrow_date")
    private LocalDate borrowing_date;

    @Temporal(TemporalType.DATE)
    @Column(name = "book_return_date")
    private LocalDate return_date;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "book_borrow_id", referencedColumnName = "book_id")
    private Book book;
}
