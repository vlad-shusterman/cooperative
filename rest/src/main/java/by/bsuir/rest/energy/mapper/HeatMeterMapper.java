package by.bsuir.rest.energy.mapper;

import by.bsuir.rest.energy.model.HeatMeterDTO;
import by.bsuir.rest.mapper.EntityMapper;
import model.entity.meter.HeatMeter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HeatMeterMapper extends EntityMapper<HeatMeterDTO, HeatMeter> {
}
