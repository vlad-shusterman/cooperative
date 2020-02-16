package by.bsuir.registry.service;

import by.bsuir.registry.exceptions.DataManipulateException;
import by.bsuir.registry.model.Person;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public interface PersonManager extends BaseManager<Person> {

    Person update(Person person) throws DataManipulateException;

}
