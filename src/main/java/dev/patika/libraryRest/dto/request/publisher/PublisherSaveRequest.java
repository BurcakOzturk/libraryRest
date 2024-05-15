package dev.patika.libraryRest.dto.request.publisher;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PublisherSaveRequest {

    @NotNull
    private String name;

    private int establishmentYear;

    @NotNull
    private String address;

}
