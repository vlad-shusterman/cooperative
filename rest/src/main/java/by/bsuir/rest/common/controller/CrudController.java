package by.bsuir.rest.common.controller;

import by.bsuir.core.service.CrudManager;
import by.bsuir.rest.common.mapper.EntityMapper;
import by.bsuir.rest.registry.IDValidationGroup;
import by.bsuir.rest.registry.controller.BaseController;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * @author Vladislav Novitskiy
 */
public class CrudController<X extends CrudManager<T>, Y, T> extends BaseController<X, Y, T> {
    protected CrudController(X baseManager, EntityMapper<Y, T> entityMapper) {
        super(baseManager, entityMapper);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Void> delete(@RequestBody @Validated(value = IDValidationGroup.class) @Valid Y y) {
        baseManager.delete(entityMapper.fromDto(y));
        return ResponseEntity.ok().build();
    }
}
