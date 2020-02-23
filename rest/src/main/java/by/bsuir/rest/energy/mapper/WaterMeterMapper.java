package by.bsuir.rest.energy.mapper;

import by.bsuir.rest.energy.model.WaterMeterDTO;
import by.bsuir.rest.mapper.EntityMapper;
import model.entity.meter.WaterMeter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WaterMeterMapper extends EntityMapper<WaterMeterDTO, WaterMeter> {
}
