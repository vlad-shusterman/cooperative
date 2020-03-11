package by.bsuir.rest.document.mapper;

import by.bsuir.document.model.document.Agreement;
import by.bsuir.rest.common.mapper.EntityMapper;
import by.bsuir.rest.document.model.AgreementEntity;
import org.mapstruct.Mapper;

/**
 * @author Vladislav Novitskiy
 */
@Mapper(componentModel = "spring")
public interface AgreementMapper extends EntityMapper<AgreementEntity, Agreement> {
}
