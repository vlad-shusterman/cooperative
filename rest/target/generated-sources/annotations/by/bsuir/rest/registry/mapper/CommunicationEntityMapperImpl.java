package by.bsuir.rest.registry.mapper;

import by.bsuir.registry.model.Communication;
import by.bsuir.rest.registry.model.CommunicationEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-03-10T22:50:10+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class CommunicationEntityMapperImpl implements CommunicationEntityMapper {

    @Override
    public CommunicationEntity toDto(Communication entity) {
        if ( entity == null ) {
            return null;
        }

        CommunicationEntity communicationEntity = new CommunicationEntity();

        communicationEntity.setId( entity.getId() );
        communicationEntity.setPersonId( entity.getPersonId() );
        communicationEntity.setCommunicationType( entity.getCommunicationType() );
        communicationEntity.setCommunicationValue( entity.getCommunicationValue() );

        return communicationEntity;
    }

    @Override
    public Communication fromDto(CommunicationEntity dto) {
        if ( dto == null ) {
            return null;
        }

        Communication communication = new Communication();

        communication.setId( dto.getId() );
        communication.setPersonId( dto.getPersonId() );
        communication.setCommunicationType( dto.getCommunicationType() );
        communication.setCommunicationValue( dto.getCommunicationValue() );

        return communication;
    }
}
