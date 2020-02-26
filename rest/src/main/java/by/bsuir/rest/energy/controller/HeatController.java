package by.bsuir.rest.energy.controller;

import by.bsuir.repository.HeatMeterRepository;
import by.bsuir.rest.common.exception.EntityNotFoundException;
import by.bsuir.rest.energy.mapper.HeatMeterMapper;
import by.bsuir.rest.energy.model.HeatMeterDto;
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
@RequestMapping(value = "/api/metres/heat")
public class HeatController {

    private final HeatMeterRepository heatMeterRepository;
    private final HeatMeterMapper heatMeterMapper;

    @GetMapping
    public Page<HeatMeterDto> getAll(@PageableDefault(size = 15) Pageable pageable) {
        var heatMeters = heatMeterRepository.findAll(pageable)
                .stream()
                .map(heatMeterMapper::toDto)
                .collect(Collectors.toList());
        return new PageImpl<>(heatMeters);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HeatMeterDto> getById(@PathVariable("id") String id) {
        var heatMeter = heatMeterRepository.findById(id)
                .map(heatMeterMapper::toDto)
                .orElseThrow(EntityNotFoundException::new);
        return ResponseEntity.ok(heatMeter);
    }

    @PostMapping
    public ResponseEntity<HeatMeterDto> save(@RequestBody HeatMeterDto heatMeterDTO) {
        heatMeterDTO.setId(null);
        var entity = heatMeterMapper.fromDto(heatMeterDTO);
        var savedHeatMeter = heatMeterRepository.save(entity);

        return ResponseEntity.ok(heatMeterMapper.toDto(savedHeatMeter));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HeatMeterDto> update(@PathVariable("id") String id,
                                               @RequestBody HeatMeterDto heatMeterDTO) {
        heatMeterDTO.setId(id);
        var entity = heatMeterMapper.fromDto(heatMeterDTO);
        var updatedHeatMeter = heatMeterRepository.save(entity);

        return ResponseEntity.ok(heatMeterMapper.toDto(updatedHeatMeter));
    }

    @GetMapping("/person/{id}")
    public Page<HeatMeterDto> getByPersonId(@PageableDefault(size = 15) Pageable pageable,
                                             @PathVariable("id") String id) {
        var heatMeter = heatMeterRepository.findAllByPersonId(id, pageable)
                .stream()
                .map(heatMeterMapper::toDto)
                .collect(Collectors.toList());
        return new PageImpl<>(heatMeter);
    }
}
