package by.bsuir.rest.registry.controller;

import by.bsuir.registry.model.Person;
import by.bsuir.registry.model.Property;
import by.bsuir.registry.service.PersonManager;
import by.bsuir.registry.service.PropertyManager;
import by.bsuir.rest.mapper.EntityMapper;
import by.bsuir.rest.registry.model.OwnersEntity;
import by.bsuir.rest.registry.model.PersonEntity;
import by.bsuir.rest.registry.model.PropertyEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/owners")
public class OwnersController {

    private final PersonManager personManager;
    private final PropertyManager propertyManager;
    private final EntityMapper<PersonEntity, Person> personEntityMapper;
    private final EntityMapper<PropertyEntity, Property> propertyEntityMapper;

    public OwnersController(
            PersonManager personManager,
            PropertyManager propertyManager,
            EntityMapper<PersonEntity, Person> personEntityMapper,
            EntityMapper<PropertyEntity, Property> propertyEntityMapper
    ) {
        this.personManager = personManager;
        this.propertyManager = propertyManager;
        this.personEntityMapper = personEntityMapper;
        this.propertyEntityMapper = propertyEntityMapper;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<OwnersEntity>> get() {
        Collection<Property> properties = propertyManager.findAllWithOwners();
        Map<String, Collection<PropertyEntity>> propertiesPerPerson = new HashMap<>();
        for (Property property : properties) {
            for (Property.PropertyOwner owner : property.getOwners()) {
                propertiesPerPerson.putIfAbsent(owner.getPersonId(), new ArrayList<>());
                propertiesPerPerson.get(owner.getPersonId()).add(propertyEntityMapper.toDto(property));
            }
        }
        List<OwnersEntity> ownersEntities = new ArrayList<>();
        for (Person person : personManager.find(propertiesPerPerson.keySet())) {
            ownersEntities.add(
                    new OwnersEntity(
                            personEntityMapper.toDto(person),
                            propertiesPerPerson.getOrDefault(person.getId(), Collections.emptyList())
                    )
            );
        }
        return ResponseEntity.ok(ownersEntities);
    }

}
