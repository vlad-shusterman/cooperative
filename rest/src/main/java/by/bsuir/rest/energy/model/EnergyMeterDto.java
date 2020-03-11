package by.bsuir.rest.energy.model;

import by.bsuir.rest.registry.model.PersonEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnergyMeterDto {

    private ElectricInfoDto electricInfo;
    private HeatInfoDto heatInfo;
    private WaterInfoDto waterInfo;
    private PersonEntity person;
}
