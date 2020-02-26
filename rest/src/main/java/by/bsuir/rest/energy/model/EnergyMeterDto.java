package by.bsuir.rest.energy.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EnergyMeterDto {

    List<ElectricMeterDto> electricMeters;
    List<HeatMeterDto> heatMeters;
    List<WaterMeterDto> waterMeters;
}
