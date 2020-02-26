package by.bsuir.rest.energy.mapper;

import by.bsuir.model.entity.meter.WaterMeter;
import by.bsuir.rest.common.mapper.CompactMapper;
import by.bsuir.rest.common.mapper.EntityMapper;
import by.bsuir.rest.energy.model.WaterMeterDto;
import by.bsuir.rest.registry.mapper.PersonMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {PersonMapper.class})
public interface WaterMeterMapper extends EntityMapper<WaterMeterDto, WaterMeter> {

    @Override
    @Mapping(target = "person", qualifiedBy = CompactMapper.class)
    WaterMeterDto toDto(WaterMeter entity);
}
