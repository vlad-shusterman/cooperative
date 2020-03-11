package by.bsuir.registry.service;

import by.bsuir.core.exceptions.DataManipulateException;
import by.bsuir.core.service.BaseManager;
import by.bsuir.registry.model.Person;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public interface PersonManager extends BaseManager<Person> {

    Person update(Person person) throws DataManipulateException;

    /**
     * Method resolve full name from person.
     *
     * @param person Persons info
     * @return Persons full name
     */
    String getFullName(Person person);

}
