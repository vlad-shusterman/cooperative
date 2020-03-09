package by.bsuir.rest.registry.mapper;

import by.bsuir.registry.model.VicariousAuthority;
import by.bsuir.rest.registry.model.VicariousAuthorityEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-03-09T21:23:15+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class VicariousAuthorityEntityMapperImpl implements VicariousAuthorityEntityMapper {

    @Override
    public VicariousAuthorityEntity toDto(VicariousAuthority entity) {
        if ( entity == null ) {
            return null;
        }

        VicariousAuthorityEntity vicariousAuthorityEntity = new VicariousAuthorityEntity();

        vicariousAuthorityEntity.setId( entity.getId() );
        vicariousAuthorityEntity.setProprietorId( entity.getProprietorId() );
        vicariousAuthorityEntity.setStartDate( entity.getStartDate() );
        vicariousAuthorityEntity.setDuration( entity.getDuration() );
        vicariousAuthorityEntity.setPersonId( entity.getPersonId() );

        return vicariousAuthorityEntity;
    }

    @Override
    public VicariousAuthority fromDto(VicariousAuthorityEntity dto) {
        if ( dto == null ) {
            return null;
        }

        VicariousAuthority vicariousAuthority = new VicariousAuthority();

        vicariousAuthority.setId( dto.getId() );
        vicariousAuthority.setProprietorId( dto.getProprietorId() );
        vicariousAuthority.setStartDate( dto.getStartDate() );
        vicariousAuthority.setDuration( dto.getDuration() );
        vicariousAuthority.setPersonId( dto.getPersonId() );

        return vicariousAuthority;
    }
}
