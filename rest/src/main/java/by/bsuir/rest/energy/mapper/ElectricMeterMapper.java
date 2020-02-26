package by.bsuir.rest.energy.mapper;

import by.bsuir.model.entity.meter.ElectricMeter;
import by.bsuir.rest.common.mapper.CompactMapper;
import by.bsuir.rest.common.mapper.EntityMapper;
import by.bsuir.rest.energy.model.ElectricMeterDto;
import by.bsuir.rest.registry.mapper.PersonMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {PersonMapper.class})
public interface ElectricMeterMapper extends EntityMapper<ElectricMeterDto, ElectricMeter> {

    @Override
    @Mapping(target = "person", qualifiedBy = CompactMapper.class)
    ElectricMeterDto toDto(ElectricMeter entity);
}
