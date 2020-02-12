package by.bsuir.rest.mapper;

import by.bsuir.core.entity.Test;
import by.bsuir.rest.dto.TestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TestMapper extends EntityMapper<TestDto, Test> {
}
