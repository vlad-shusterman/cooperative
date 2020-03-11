package by.bsuir.rest.energy.controller;

import by.bsuir.repository.ElectricMeterRepository;
import by.bsuir.rest.energy.mapper.ElectricMeterMapper;
import by.bsuir.rest.energy.model.ElectricMeterDto;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@Api
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/metres/electric")
public class ElectricMeterController {

    private final ElectricMeterRepository electricMeterRepository;
    private final ElectricMeterMapper electricMeterMapper;

    @GetMapping
    public Page<ElectricMeterDto> getAll(@PageableDefault(size = 15) Pageable pageable) {
        var electricMeters = electricMeterRepository.findAll(pageable)
                .stream()
                .map(electricMeterMapper::toDto)
                .collect(Collectors.toList());
        return new PageImpl<>(electricMeters);
    }

    @PostMapping
    public ResponseEntity<ElectricMeterDto> save(@RequestBody ElectricMeterDto electricMeterDTO) {
        electricMeterDTO.setId(null);
        var entity = electricMeterMapper.fromDto(electricMeterDTO);
        var savedElectricMeter = electricMeterRepository.save(entity);

        return ResponseEntity.ok(electricMeterMapper.toDto(savedElectricMeter));
    }

    @GetMapping("/person/{id}")
    public Page<ElectricMeterDto> getByPersonId(@PageableDefault(size = 15) Pageable pageable,
                                                @PathVariable("id") String id) {
        var electricMeter = electricMeterRepository.findAllByPersonId(id, pageable)
                .stream()
                .map(electricMeterMapper::toDto)
                .collect(Collectors.toList());
        return new PageImpl<>(electricMeter);
    }
}
