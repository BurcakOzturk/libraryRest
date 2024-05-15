package dev.patika.libraryRest.dto.request.category;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CategorySaveRequest {

    @NotNull(message = "Kategori Adı Boş Olamaz")
    private String name;

    private String description;

}
