package by.bsuir.rest.energy.mapper;

import by.bsuir.model.entity.ElectricInfo;
import by.bsuir.rest.common.mapper.EntityMapper;
import by.bsuir.rest.energy.model.ElectricInfoDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ElectricMeterMapper.class})
public interface ElectricInfoMapper extends EntityMapper<ElectricInfoDto, ElectricInfo> {
}
