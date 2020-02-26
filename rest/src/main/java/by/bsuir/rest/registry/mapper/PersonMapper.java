package by.bsuir.rest.registry.mapper;

import by.bsuir.registry.model.Person;
import by.bsuir.rest.common.mapper.CompactMapper;
import by.bsuir.rest.common.mapper.EntityMapper;
import by.bsuir.rest.registry.model.PersonEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PersonMapper extends EntityMapper<PersonEntity, Person> {

    @CompactMapper
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "surname", target = "surname"),
            @Mapping(source = "lastName", target = "lastName")
    })
    @BeanMapping(ignoreByDefault = true)
    PersonEntity toDtoCompact(Person person);
}
