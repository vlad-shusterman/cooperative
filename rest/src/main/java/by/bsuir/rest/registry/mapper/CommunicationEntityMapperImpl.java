package by.bsuir.rest.registry.mapper;

import by.bsuir.registry.model.Communication;
import by.bsuir.rest.mapper.EntityMapper;
import by.bsuir.rest.registry.model.CommunicationEntity;
import org.springframework.stereotype.Service;

@Service
public class CommunicationEntityMapperImpl implements EntityMapper<CommunicationEntity, Communication> {

    @Override
    public CommunicationEntity toDto(Communication entity) {
        return new CommunicationEntity(
                entity.getId(),
                entity.getPersonId(),
                entity.getCommunicationType(),
                entity.getCommunicationValue()
        );
    }

    @Override
    public Communication fromDto(CommunicationEntity dto) {
        return new Communication(
                dto.getId(),
                dto.getPersonId(),
                dto.getCommunicationType(),
                dto.getCommunicationValue()
        );
    }

}
