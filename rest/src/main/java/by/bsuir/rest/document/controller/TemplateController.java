package by.bsuir.rest.document.controller;

import by.bsuir.document.model.template.Template;
import by.bsuir.document.service.template.TemplateManager;
import by.bsuir.rest.common.mapper.EntityMapper;
import by.bsuir.rest.document.model.TemplateEntity;
import by.bsuir.rest.registry.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vladislav Novitskiy
 */
@RestController
@RequestMapping("/api/template")
public class TemplateController extends BaseController<TemplateManager, TemplateEntity, Template> {
    protected TemplateController(
            TemplateManager baseManager,
            EntityMapper<TemplateEntity, Template> entityMapper) {
        super(baseManager, entityMapper);
    }
}
