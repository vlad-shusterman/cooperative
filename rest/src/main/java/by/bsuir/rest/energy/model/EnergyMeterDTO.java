package by.bsuir.rest.energy.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EnergyMeterDTO {

    @JsonProperty("electricMeters")
    List<ElectricMeterDTO> electricMeters;

    @JsonProperty("heatMeters")
    List<HeatMeterDTO> heatMeters;

    @JsonProperty("waterMeters")
    List<WaterMeterDTO> waterMeters;
}
