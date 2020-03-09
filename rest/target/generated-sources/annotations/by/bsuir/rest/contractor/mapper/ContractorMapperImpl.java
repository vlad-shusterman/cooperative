package by.bsuir.rest.contractor.mapper;

import by.bsuir.model.entity.contractor.Contractor;
import by.bsuir.model.entity.contractor.ContractorType;
import by.bsuir.rest.contractor.model.ContractorDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-03-09T21:23:15+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class ContractorMapperImpl implements ContractorMapper {

    @Override
    public ContractorDto toDto(Contractor entity) {
        if ( entity == null ) {
            return null;
        }

        ContractorDto contractorDto = new ContractorDto();

        contractorDto.setId( entity.getId() );
        if ( entity.getType() != null ) {
            contractorDto.setType( entity.getType().name() );
        }
        contractorDto.setFullName( entity.getFullName() );
        contractorDto.setJuridicalAccount( entity.getJuridicalAccount() );
        contractorDto.setPaymentAccount( entity.getPaymentAccount() );
        contractorDto.setPostAddress( entity.getPostAddress() );
        contractorDto.setHeadName( entity.getHeadName() );
        contractorDto.setHeadPost( entity.getHeadPost() );
        contractorDto.setRegistrationDate( entity.getRegistrationDate() );
        contractorDto.setDescription( entity.getDescription() );

        return contractorDto;
    }

    @Override
    public Contractor fromDto(ContractorDto dto) {
        if ( dto == null ) {
            return null;
        }

        Contractor contractor = new Contractor();

        contractor.setId( dto.getId() );
        if ( dto.getType() != null ) {
            contractor.setType( Enum.valueOf( ContractorType.class, dto.getType() ) );
        }
        contractor.setFullName( dto.getFullName() );
        contractor.setJuridicalAccount( dto.getJuridicalAccount() );
        contractor.setPaymentAccount( dto.getPaymentAccount() );
        contractor.setPostAddress( dto.getPostAddress() );
        contractor.setHeadName( dto.getHeadName() );
        contractor.setHeadPost( dto.getHeadPost() );
        contractor.setRegistrationDate( dto.getRegistrationDate() );
        contractor.setDescription( dto.getDescription() );

        return contractor;
    }
}
