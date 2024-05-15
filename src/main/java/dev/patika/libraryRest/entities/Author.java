package dev.patika.libraryRest.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="authors")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "aut_id")
    private int id;

    @NotNull
    @Column (name = "aut_name")
    private String name;

    @Column (name = "aut_birth_date")
    private LocalDate birthDate;

    @Column (name = "aut_country")
    private String country;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Book> bookList;
}
