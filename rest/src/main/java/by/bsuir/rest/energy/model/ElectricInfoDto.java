package by.bsuir.rest.energy.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ElectricInfoDto {

    private String id;
    private ElectricMeterDto electricMeter;
    private Double value;
    private LocalDate readingDate;
}
