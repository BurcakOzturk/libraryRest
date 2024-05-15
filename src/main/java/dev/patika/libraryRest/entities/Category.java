package dev.patika.libraryRest.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="categories")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id")
    private int id;

    @NotNull
    @Column(name = "cat_name", length = 100)
    private String name;

    @Column(name = "cat_description", length = 200)
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "category_of_book",
            joinColumns = {@JoinColumn(name = "category_of_book_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_of_category_id")})
    private List<Book> bookList;

}
