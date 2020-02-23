package by.bsuir.registry.service;

import by.bsuir.registry.model.Property;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Collection;

@ParametersAreNonnullByDefault
public interface PropertyManager extends BaseManager<Property> {

    Collection<Property> findAllWithOwners();

}
