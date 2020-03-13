package by.bsuir.rest.energy.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class HeatInfoDto {

    private String id;
    private HeatMeterDto heatMeter;
    private Double value;
    private LocalDate readingDate;
}
