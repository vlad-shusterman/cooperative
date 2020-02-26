package by.bsuir.rest.energy.controller;

import by.bsuir.repository.WaterMeterRepository;
import by.bsuir.rest.common.exception.EntityNotFoundException;
import by.bsuir.rest.energy.mapper.WaterMeterMapper;
import by.bsuir.rest.energy.model.WaterMeterDto;
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
@RequestMapping(value = "/api/metres/water")
public class WaterMeterController {

    private final WaterMeterRepository waterMeterRepository;
    private final WaterMeterMapper waterMeterMapper;

    @GetMapping
    public Page<WaterMeterDto> getAll(@PageableDefault(size = 15) Pageable pageable) {
        var waterMeters = waterMeterRepository.findAll(pageable)
                .stream()
                .map(waterMeterMapper::toDto)
                .collect(Collectors.toList());
        return new PageImpl<>(waterMeters);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WaterMeterDto> getById(@PathVariable("id") String id) {
        var waterMeter = waterMeterRepository.findById(id)
                .map(waterMeterMapper::toDto)
                .orElseThrow(EntityNotFoundException::new);
        return ResponseEntity.ok(waterMeter);
    }

    @GetMapping("/person/{id}")
    public Page<WaterMeterDto> getByPersonId(@PageableDefault(size = 15) Pageable pageable,
                                             @PathVariable("id") String id) {
        var waterMeter = waterMeterRepository.findAllByPersonId(id, pageable)
                .stream()
                .map(waterMeterMapper::toDto)
                .collect(Collectors.toList());
        return new PageImpl<>(waterMeter);
    }

    @PostMapping
    public ResponseEntity<WaterMeterDto> save(@RequestBody WaterMeterDto waterMeterDTO) {
        waterMeterDTO.setId(null);
        var entity = waterMeterMapper.fromDto(waterMeterDTO);
        var savedWaterMeter = waterMeterRepository.save(entity);

        return ResponseEntity.ok(waterMeterMapper.toDto(savedWaterMeter));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WaterMeterDto> update(@PathVariable("id") String id,
                                                @RequestBody WaterMeterDto waterMeterDTO) {
        waterMeterDTO.setId(id);
        var entity = waterMeterMapper.fromDto(waterMeterDTO);
        var savedWaterMeter = waterMeterRepository.save(entity);

        return ResponseEntity.ok(waterMeterMapper.toDto(savedWaterMeter));
    }
}
