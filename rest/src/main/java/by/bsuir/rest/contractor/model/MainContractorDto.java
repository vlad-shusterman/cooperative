package by.bsuir.rest.contractor.model;

import by.bsuir.rest.energy.model.ElectricMeterDto;
import by.bsuir.rest.energy.model.HeatMeterDto;
import by.bsuir.rest.energy.model.WaterMeterDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MainContractorDto {
    List<ContractorDto> contractors;
    List<AuthorityDto> authorities;
}
