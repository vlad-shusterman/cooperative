package by.bsuir.rest.energy.model;

import by.bsuir.model.entity.meter.WaterMeter;
import by.bsuir.model.entity.meter.WaterMeterType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class WaterInfoDto {

    private String id;
    private WaterMeterDto waterMeter;
    private Double value;
    private LocalDate readingDate;
    private WaterMeterType waterMeterType;
}
