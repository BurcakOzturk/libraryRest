package dev.patika.libraryRest.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="books")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "book_id")
    private int id;

    @NotNull
    @Column (name = "book_name")
    private String name;

    @NotNull
    @Column (name = "book_publication_year")
    private int publicationYear;

    @Column (name = "book_stock")
    private int stock;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn (name = "book_publisher_id", referencedColumnName = "pub_id")
    private Publisher publisher;

    @ManyToMany(mappedBy = "bookList")
    private List<Category>
            categoryList;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "book_author_id", referencedColumnName = "aut_id")
    private Author author;

    @OneToMany(mappedBy = "book")
    private List<BookBorrowing> bookBorrowingList;
}
