package by.bsuir.rest.energy.mapper;

import by.bsuir.model.entity.HeatInfo;
import by.bsuir.rest.common.mapper.EntityMapper;
import by.bsuir.rest.energy.model.HeatInfoDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {HeatMeterMapper.class})
public interface HeatInfoMapper extends EntityMapper<HeatInfoDto, HeatInfo> {
}
