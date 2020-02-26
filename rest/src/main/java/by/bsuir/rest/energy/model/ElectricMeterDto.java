package by.bsuir.rest.energy.model;

import by.bsuir.rest.registry.model.PersonEntity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDate;

@Data
public class ElectricMeterDto {

    private String id;
    private Double value;
    @NotBlank
    private String number;
    @NotNull
    private LocalDate readingDate;
    @NotNull
    private Double transformationRatio;
    @NotNull
    private PersonEntity person;
}
