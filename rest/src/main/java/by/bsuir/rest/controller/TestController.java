package by.bsuir.rest.controller;

import by.bsuir.core.service.TestService;
import by.bsuir.rest.converter.TestConverter;
import by.bsuir.rest.dto.TestDto;
import by.bsuir.rest.mapper.TestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/tests")
public class TestController {

    private final TestConverter testConverter;
    private final TestService testService;
    private final TestMapper testMapper;

    @GetMapping
    public ResponseEntity<List<TestDto>> finAll() {
        var testDtos = testService.findAllTestEntities()
                .stream()
                .map(testMapper::toDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(testDtos);
    }

    @PostMapping
    public ResponseEntity<TestDto> create(@RequestBody TestDto testDto) {
        var test = testConverter.convert(testDto);
        var saved = testService.save(test);
        return ResponseEntity.ok(testMapper.toDto(saved));
    }
}
