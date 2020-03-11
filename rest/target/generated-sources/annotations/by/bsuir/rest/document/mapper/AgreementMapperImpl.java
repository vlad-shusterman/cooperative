package by.bsuir.rest.document.mapper;

import by.bsuir.document.model.document.Agreement;
import by.bsuir.rest.document.model.AgreementEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-03-10T22:50:10+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class AgreementMapperImpl implements AgreementMapper {

    @Override
    public AgreementEntity toDto(Agreement entity) {
        if ( entity == null ) {
            return null;
        }

        AgreementEntity agreementEntity = new AgreementEntity();

        agreementEntity.setId( entity.getId() );
        agreementEntity.setIndex( entity.getIndex() );
        agreementEntity.setProprietorId( entity.getProprietorId() );
        agreementEntity.setPropertyId( entity.getPropertyId() );

        return agreementEntity;
    }

    @Override
    public Agreement fromDto(AgreementEntity dto) {
        if ( dto == null ) {
            return null;
        }

        Agreement agreement = new Agreement();

        agreement.setId( dto.getId() );
        agreement.setIndex( dto.getIndex() );
        agreement.setProprietorId( dto.getProprietorId() );
        agreement.setPropertyId( dto.getPropertyId() );

        return agreement;
    }
}
