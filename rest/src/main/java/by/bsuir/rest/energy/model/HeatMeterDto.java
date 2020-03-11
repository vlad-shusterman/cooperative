package by.bsuir.rest.energy.model;

import by.bsuir.rest.registry.model.PersonEntity;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class HeatMeterDto {

    private String id;
    @NotBlank
    @NotNull
    private String number;
    @NotNull
    private PersonEntity person;
}
