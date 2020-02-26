package by.bsuir.rest.registry.controller;

import by.bsuir.registry.model.Person;
import by.bsuir.registry.service.PersonManager;
import by.bsuir.rest.common.mapper.EntityMapper;
import by.bsuir.rest.registry.model.PersonEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/person")
public class PersonController extends BaseController<PersonManager, PersonEntity, Person> {

    public PersonController(PersonManager baseManager, EntityMapper<PersonEntity, Person> entityMapper) {
        super(baseManager, entityMapper);
    }

}
