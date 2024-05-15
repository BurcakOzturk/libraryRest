package dev.patika.libraryRest.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="publishers")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Publisher {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "pub_id")
    private int id;

    @NotNull
    @Column (name = "pub_name")
    private String name;

    @Column (name = "pub_establishment_year")
    private int establishmentYear;

    @Column (name = "pub_address")
    private String address;

    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY)
    private List<Book> bookList;
}
