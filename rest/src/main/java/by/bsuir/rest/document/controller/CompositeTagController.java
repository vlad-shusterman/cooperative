package by.bsuir.rest.document.controller;

import by.bsuir.document.model.template.CompositeTag;
import by.bsuir.document.service.tag.CompositeTagManager;
import by.bsuir.rest.common.mapper.EntityMapper;
import by.bsuir.rest.document.model.CompositeTagEntity;
import by.bsuir.rest.registry.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vladislav Novitskiy
 */
@RestController
@RequestMapping("/api/comptag")
public class CompositeTagController extends BaseController<CompositeTagManager, CompositeTagEntity, CompositeTag> {

    protected CompositeTagController(CompositeTagManager baseManager,
                                     EntityMapper<CompositeTagEntity, CompositeTag> entityMapper) {
        super(baseManager, entityMapper);
    }
}
