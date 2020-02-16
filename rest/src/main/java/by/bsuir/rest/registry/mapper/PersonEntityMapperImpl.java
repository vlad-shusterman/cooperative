package by.bsuir.rest.registry.mapper;

import by.bsuir.registry.model.Person;
import by.bsuir.rest.mapper.EntityMapper;
import by.bsuir.rest.registry.model.PersonEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonEntityMapperImpl implements EntityMapper<PersonEntity, Person> {

    @Override
    public Person fromDto(PersonEntity dto) {
        return new Person(
                dto.getId(),
                dto.getName(),
                dto.getSurname(),
                dto.getLastName(),
                dto.getPassportData() == null ? null : new Person.PassportData(
                        dto.getPassportData().getNumber(),
                        dto.getPassportData().getData(),
                        dto.getPassportData().getIssuingAuthority(),
                        dto.getPassportData().getPersonalNumber()
                ),
                dto.getDocumentType()
        );
    }

    @Override
    public PersonEntity toDto(Person entity) {
        return new PersonEntity(
                entity.getId(),
                entity.getName(),
                entity.getSurname(),
                entity.getLastName(),
                entity.getDocumentType(),
                entity.getPassportData() == null ? null : new PersonEntity.PassportData(
                        entity.getPassportData().getNumber(),
                        entity.getPassportData().getData(),
                        entity.getPassportData().getIssuingAuthority(),
                        entity.getPassportData().getPersonalNumber()
                )
        );
    }

}
