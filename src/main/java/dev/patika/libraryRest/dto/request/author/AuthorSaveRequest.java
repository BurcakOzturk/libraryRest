package dev.patika.libraryRest.dto.request.author;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AuthorSaveRequest {

    @NotNull
    private String name;

    private LocalDate birthDate;

    private String country;
}
