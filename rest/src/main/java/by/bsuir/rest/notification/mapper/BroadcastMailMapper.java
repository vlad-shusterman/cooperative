package by.bsuir.rest.notification.mapper;

import by.bsuir.notification.entity.BroadcastMail;
import by.bsuir.rest.common.mapper.EntityMapper;
import by.bsuir.rest.notification.model.BroadcastMailDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BroadcastMailMapper extends EntityMapper<BroadcastMailDto, BroadcastMail> {
}
