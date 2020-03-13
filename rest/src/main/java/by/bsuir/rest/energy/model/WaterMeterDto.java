package by.bsuir.rest.energy.model;

import by.bsuir.model.entity.meter.WaterMeterType;
import by.bsuir.rest.registry.model.PersonEntity;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class WaterMeterDto {

    private String id;
    @NotBlank
    @NotNull
    private String number;
    @NotBlank
    @NotNull
    private WaterMeterType waterMeterType;
    @NotNull
    private PersonEntity person;
}
