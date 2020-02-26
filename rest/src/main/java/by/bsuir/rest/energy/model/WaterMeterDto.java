package by.bsuir.rest.energy.model;

import by.bsuir.rest.registry.model.PersonEntity;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class WaterMeterDto {

    private String id;
    private Double value;
    @NotBlank
    private String number;
    @NotNull
    private LocalDate readingDate;
    @NotBlank
    private String type;
    @NotNull
    private PersonEntity person;
}
