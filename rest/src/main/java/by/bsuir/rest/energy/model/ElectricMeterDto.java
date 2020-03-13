package by.bsuir.rest.energy.model;

import by.bsuir.rest.registry.model.PersonEntity;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ElectricMeterDto {

    private String id;
    @NotNull
    private Double transformationRatio;

    @NotBlank
    @NotNull
    private String number;

    @NotNull
    private PersonEntity person;
}
