package by.bsuir.rest.energy.mapper;

import by.bsuir.model.entity.meter.HeatMeter;
import by.bsuir.rest.common.mapper.CompactMapper;
import by.bsuir.rest.common.mapper.EntityMapper;
import by.bsuir.rest.energy.model.HeatMeterDto;
import by.bsuir.rest.registry.mapper.PersonMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {PersonMapper.class})
public interface HeatMeterMapper extends EntityMapper<HeatMeterDto, HeatMeter> {

    @Override
    @Mapping(target = "person", qualifiedBy = CompactMapper.class)
    HeatMeterDto toDto(HeatMeter entity);
}
