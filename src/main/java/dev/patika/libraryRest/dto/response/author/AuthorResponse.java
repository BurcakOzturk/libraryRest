package dev.patika.libraryRest.dto.response.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponse {
    private int id;
    private String name;
    private LocalDate birthDate;
    private String country;
}
