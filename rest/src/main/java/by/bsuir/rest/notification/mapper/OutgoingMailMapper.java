package by.bsuir.rest.notification.mapper;

import by.bsuir.notification.entity.OutgoingMail;
import by.bsuir.rest.common.mapper.EntityMapper;
import by.bsuir.rest.notification.model.OutgoingMailDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OutgoingMailMapper extends EntityMapper<OutgoingMailDto, OutgoingMail> {

    @Override
    @Mapping(target = "sendingDate")
    OutgoingMailDto toDto(OutgoingMail entity);

    @Override
    @Mapping(target = "sendingDate", ignore = true)
    OutgoingMail fromDto(OutgoingMailDto dto);
}
