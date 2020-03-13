package by.bsuir.document.processor.impl;

import by.bsuir.document.exception.EntityNotFoundException;
import by.bsuir.document.model.template.Tag;
import by.bsuir.document.processor.TagProcessor;
import by.bsuir.registry.model.Person;
import by.bsuir.registry.service.PersonManager;
import lombok.AllArgsConstructor;

import java.util.Map;

import static by.bsuir.document.model.template.Tag.Param.PERSON_ID;

/**
 * @author Vladislav Novitskiy
 */
@AllArgsConstructor
public class PNProcessor implements TagProcessor {
    private PersonManager personManager;

    @Override
    public Object process(Map<Tag.Param, String> paramValues) {
        String ownerId = paramValues.get(PERSON_ID);

        Person person = personManager.find(ownerId);
        if (person == null) {
            throw new EntityNotFoundException("No owner with id '" + ownerId + "'");
        }

        Person.PassportData passportData = person.getPassportData();
        return passportData.getPersonalNumber();
    }
}
