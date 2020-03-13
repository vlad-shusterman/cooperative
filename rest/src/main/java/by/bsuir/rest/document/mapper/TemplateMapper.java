package by.bsuir.rest.document.mapper;

import by.bsuir.document.model.template.Template;
import by.bsuir.rest.common.mapper.EntityMapper;
import by.bsuir.rest.document.model.TemplateEntity;
import org.mapstruct.Mapper;

/**
 * @author Vladislav Novitskiy
 */
@Mapper(componentModel = "spring")
public interface TemplateMapper extends EntityMapper<TemplateEntity, Template> {
}
