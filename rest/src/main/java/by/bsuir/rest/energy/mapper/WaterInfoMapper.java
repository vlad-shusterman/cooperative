package by.bsuir.rest.energy.mapper;

import by.bsuir.model.entity.WaterInfo;
import by.bsuir.rest.common.mapper.EntityMapper;
import by.bsuir.rest.energy.model.WaterInfoDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {WaterMeterMapper.class})
public interface WaterInfoMapper extends EntityMapper<WaterInfoDto, WaterInfo> {
}
