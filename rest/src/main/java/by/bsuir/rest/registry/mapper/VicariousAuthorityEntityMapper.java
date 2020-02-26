package by.bsuir.rest.registry.mapper;

import by.bsuir.registry.model.VicariousAuthority;
import by.bsuir.rest.common.mapper.EntityMapper;
import by.bsuir.rest.registry.model.VicariousAuthorityEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
public interface VicariousAuthorityEntityMapper extends EntityMapper<VicariousAuthorityEntity, VicariousAuthority> {
}
