package by.bsuir.rest.converter;

import by.bsuir.core.entity.Test;
import by.bsuir.rest.dto.TestDto;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TestConverter implements Converter<TestDto, Test> {

    @Override
    public Test convert(TestDto testDto) {
        var test = new Test();
        BeanUtils.copyProperties(testDto, test);

        return test;
    }
}
