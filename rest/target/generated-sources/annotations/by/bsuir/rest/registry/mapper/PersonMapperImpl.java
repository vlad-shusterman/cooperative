package by.bsuir.rest.registry.mapper;

import by.bsuir.registry.model.Person;
import by.bsuir.registry.model.Person.PassportData;
import by.bsuir.rest.registry.model.PersonEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-03-10T22:50:10+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public PersonEntity toDto(Person entity) {
        if ( entity == null ) {
            return null;
        }

        PersonEntity personEntity = new PersonEntity();

        personEntity.setId( entity.getId() );
        personEntity.setName( entity.getName() );
        personEntity.setSurname( entity.getSurname() );
        personEntity.setLastName( entity.getLastName() );
        personEntity.setDocumentType( entity.getDocumentType() );
        personEntity.setPassportData( passportDataToPassportData( entity.getPassportData() ) );

        return personEntity;
    }

    @Override
    public Person fromDto(PersonEntity dto) {
        if ( dto == null ) {
            return null;
        }

        Person person = new Person();

        person.setId( dto.getId() );
        person.setName( dto.getName() );
        person.setSurname( dto.getSurname() );
        person.setLastName( dto.getLastName() );
        person.setDocumentType( dto.getDocumentType() );
        person.setPassportData( passportDataToPassportData1( dto.getPassportData() ) );

        return person;
    }

    @Override
    public PersonEntity toDtoCompact(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonEntity personEntity = new PersonEntity();

        personEntity.setName( person.getName() );
        personEntity.setLastName( person.getLastName() );
        personEntity.setId( person.getId() );
        personEntity.setSurname( person.getSurname() );

        return personEntity;
    }

    protected by.bsuir.rest.registry.model.PersonEntity.PassportData passportDataToPassportData(PassportData passportData) {
        if ( passportData == null ) {
            return null;
        }

        by.bsuir.rest.registry.model.PersonEntity.PassportData passportData1 = new by.bsuir.rest.registry.model.PersonEntity.PassportData();

        passportData1.setNumber( passportData.getNumber() );
        passportData1.setData( passportData.getData() );
        passportData1.setIssuingAuthority( passportData.getIssuingAuthority() );
        passportData1.setPersonalNumber( passportData.getPersonalNumber() );

        return passportData1;
    }

    protected PassportData passportDataToPassportData1(by.bsuir.rest.registry.model.PersonEntity.PassportData passportData) {
        if ( passportData == null ) {
            return null;
        }

        PassportData passportData1 = new PassportData();

        passportData1.setNumber( passportData.getNumber() );
        passportData1.setData( passportData.getData() );
        passportData1.setIssuingAuthority( passportData.getIssuingAuthority() );
        passportData1.setPersonalNumber( passportData.getPersonalNumber() );

        return passportData1;
    }
}
