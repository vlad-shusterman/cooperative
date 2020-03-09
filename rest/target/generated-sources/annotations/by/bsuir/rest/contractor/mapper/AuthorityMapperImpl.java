package by.bsuir.rest.contractor.mapper;

import by.bsuir.model.entity.contractor.Authority;
import by.bsuir.rest.contractor.model.AuthorityDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-03-09T21:23:15+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class AuthorityMapperImpl implements AuthorityMapper {

    @Override
    public AuthorityDto toDto(Authority entity) {
        if ( entity == null ) {
            return null;
        }

        AuthorityDto authorityDto = new AuthorityDto();

        authorityDto.setId( entity.getId() );
        authorityDto.setFullName( entity.getFullName() );
        authorityDto.setJuridicalAccount( entity.getJuridicalAccount() );
        authorityDto.setPostAddress( entity.getPostAddress() );
        authorityDto.setHeadName( entity.getHeadName() );
        authorityDto.setHeadPost( entity.getHeadPost() );
        authorityDto.setRegistrationDate( entity.getRegistrationDate() );
        authorityDto.setDescription( entity.getDescription() );

        return authorityDto;
    }

    @Override
    public Authority fromDto(AuthorityDto dto) {
        if ( dto == null ) {
            return null;
        }

        Authority authority = new Authority();

        authority.setId( dto.getId() );
        authority.setFullName( dto.getFullName() );
        authority.setJuridicalAccount( dto.getJuridicalAccount() );
        authority.setPostAddress( dto.getPostAddress() );
        authority.setHeadName( dto.getHeadName() );
        authority.setHeadPost( dto.getHeadPost() );
        authority.setRegistrationDate( dto.getRegistrationDate() );
        authority.setDescription( dto.getDescription() );

        return authority;
    }
}
