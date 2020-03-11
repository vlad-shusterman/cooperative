package by.bsuir.rest.contractor.mapper;

import by.bsuir.model.entity.contractor.Authority;
import by.bsuir.rest.common.mapper.EntityMapper;
import by.bsuir.rest.contractor.model.AuthorityDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorityMapper extends EntityMapper<AuthorityDto, Authority> {

}
