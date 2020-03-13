package by.bsuir.document.processor.impl;

import by.bsuir.document.model.template.Tag;
import by.bsuir.document.processor.TagProcessor;
import by.bsuir.registry.model.Person;
import by.bsuir.registry.service.PersonManager;
import lombok.AllArgsConstructor;

import java.util.Map;

/**
 * {@link TagProcessor} of {@link Tag#FAMILY}.
 *
 * @author Vladislav Novitskiy
 */
@AllArgsConstructor
public class FamilyProcessor implements TagProcessor {
    private PersonManager personManager;

    @Override
    public Object process(Map<Tag.Param, String> paramValues) {
        String ownerId = paramValues.get(Tag.Param.PERSON_ID);
        Person person = personManager.findOrThrow(ownerId);
        return personManager.getFullName(person);
    }
}
