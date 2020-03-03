package by.bsuir.rest.notification.mapper;

import by.bsuir.notification.entity.IncomingMail;
import by.bsuir.rest.common.mapper.EntityMapper;
import by.bsuir.rest.notification.model.IncomingMailDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IncomingMailMapper extends EntityMapper<IncomingMailDto, IncomingMail> {
}
