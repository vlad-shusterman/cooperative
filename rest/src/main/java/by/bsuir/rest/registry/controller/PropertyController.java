package by.bsuir.rest.registry.controller;

import by.bsuir.registry.model.Property;
import by.bsuir.registry.service.PropertyManager;
import by.bsuir.rest.common.mapper.EntityMapper;
import by.bsuir.rest.registry.model.PropertyEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/property")
public class PropertyController extends BaseController<PropertyManager, PropertyEntity, Property> {

    public PropertyController(PropertyManager baseManager, EntityMapper<PropertyEntity, Property> entityMapper) {
        super(baseManager, entityMapper);
    }

}
