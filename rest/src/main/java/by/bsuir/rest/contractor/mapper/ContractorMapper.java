package by.bsuir.rest.contractor.mapper;

import by.bsuir.model.entity.contractor.Contractor;
import by.bsuir.rest.common.mapper.EntityMapper;
import by.bsuir.rest.contractor.model.ContractorDto;
import org.mapstruct.Mapper;

@Mapper(componentModel ="spring")
public interface ContractorMapper extends EntityMapper<ContractorDto, Contractor> {
}
