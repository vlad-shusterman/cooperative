package by.bsuir.rest.document.mapper;

import by.bsuir.document.model.template.CompositeTag;
import by.bsuir.rest.common.mapper.EntityMapper;
import by.bsuir.rest.document.model.CompositeTagEntity;
import org.mapstruct.Mapper;

/**
 * @author Vladislav Novitskiy
 */
@Mapper(componentModel = "spring")
public interface CompositeTagMapper extends EntityMapper<CompositeTagEntity, CompositeTag> {
}
