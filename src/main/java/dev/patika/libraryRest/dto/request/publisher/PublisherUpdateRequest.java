package dev.patika.libraryRest.dto.request.publisher;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublisherUpdateRequest {
    @Positive(message = "ID değeri pozitif sayı olmak zorunda")
    private int id;

    @NotNull(message = "Kategori ismi boş veya null olamaz")
    private String name;

    private int establishmentYear;

    @NotNull
    private String address;
}
