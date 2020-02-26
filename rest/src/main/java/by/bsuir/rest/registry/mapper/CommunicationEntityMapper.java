package by.bsuir.rest.registry.mapper;

import by.bsuir.registry.model.Communication;
import by.bsuir.rest.common.mapper.EntityMapper;
import by.bsuir.rest.registry.model.CommunicationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommunicationEntityMapper extends EntityMapper<CommunicationEntity, Communication> {
}
