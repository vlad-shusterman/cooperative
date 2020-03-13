package by.bsuir.rest.energy.controller;

import by.bsuir.export.service.ExportService;
import by.bsuir.export.template.ElectricTemplate;
import by.bsuir.model.entity.ElectricInfo;
import by.bsuir.registry.repository.PersonRepository;
import by.bsuir.repository.*;
import by.bsuir.rest.common.exception.EntityNotFoundException;
import by.bsuir.rest.energy.mapper.ElectricInfoMapper;
import by.bsuir.rest.energy.mapper.HeatInfoMapper;
import by.bsuir.rest.energy.mapper.WaterInfoMapper;
import by.bsuir.rest.energy.model.ElectricInfoDto;
import by.bsuir.rest.energy.model.EnergyMeterDto;
import by.bsuir.rest.energy.model.HeatInfoDto;
import by.bsuir.rest.energy.model.WaterInfoDto;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;
import java.util.stream.Collectors;

@Api
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/energy")
public class EnergyMeterController {

    private final ElectricInfoMapper electricInfoMapper;
    private final WaterInfoMapper waterInfoMapper;
    private final HeatInfoMapper heatInfoMapper;

    private final ElectricMeterRepository electricMeterRepository;
    private final ElectricInfoRepository electricInfoRepository;
    private final WaterMeterRepository waterMeterRepository;
    private final WaterInfoRepository waterInfoRepository;
    private final HeatMeterRepository heatMeterRepository;
    private final HeatInfoRepository heatInfoRepository;
    private final PersonRepository personRepository;

    private final ExportService<ElectricInfo> electricInfoExportService;

    private final ElectricTemplate electricTemplate;

    @PostMapping
    public ResponseEntity<EnergyMeterDto> save(@RequestBody @Valid EnergyMeterDto energyMeter) {
        var result = new EnergyMeterDto();
        var person = personRepository.findById(energyMeter.getPerson().getId())
                .orElseThrow(EntityNotFoundException::new);
        var electricInfo = electricInfoMapper.fromDto(energyMeter.getElectricInfo());
        if (Objects.nonNull(electricInfo)) {
            var electricMeter = electricMeterRepository.findByPerson(person)
                    .orElseThrow(EntityNotFoundException::new);
            electricInfo.setElectricMeter(electricMeter);
            var savedElectricInfo = electricInfoRepository.save(electricInfo);
            result.setElectricInfo(electricInfoMapper.toDto(savedElectricInfo));
        }

        var waterInfo = waterInfoMapper.fromDto(energyMeter.getWaterInfo());
        if (Objects.nonNull(waterInfo)) {
            var waterMeter = waterMeterRepository.findByPersonAndWaterMeterType(person, energyMeter.getWaterInfo().getWaterMeterType())
                    .orElseThrow(EntityNotFoundException::new);
            waterInfo.setWaterMeter(waterMeter);
            var savedWaterInfo = waterInfoRepository.save(waterInfo);
            result.setWaterInfo(waterInfoMapper.toDto(savedWaterInfo));
        }

        var heatInfo = heatInfoMapper.fromDto(energyMeter.getHeatInfo());
        if (Objects.nonNull(heatInfo)) {
            var heatMeter = heatMeterRepository.findByPerson(person)
                    .orElseThrow(EntityNotFoundException::new);
            heatInfo.setHeatMeter(heatMeter);
            var savedHeatInfo = heatInfoRepository.save(heatInfo);
            result.setHeatInfo(heatInfoMapper.toDto(savedHeatInfo));
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/electric")
    public Page<ElectricInfoDto> getAllElectric(@PageableDefault(size = 15) Pageable pageable) {
        var electricMeters = electricInfoRepository.findAll(pageable)
                .stream()
                .map(electricInfoMapper::toDto)
                .collect(Collectors.toList());
        return new PageImpl<>(electricMeters);
    }

    @GetMapping(value = "/water")
    public Page<WaterInfoDto> getAllWater(@PageableDefault(size = 15) Pageable pageable) {
        var electricMeters = waterInfoRepository.findAll(pageable)
                .stream()
                .map(waterInfoMapper::toDto)
                .collect(Collectors.toList());
        return new PageImpl<>(electricMeters);
    }

    @GetMapping(value = "/heat")
    public Page<HeatInfoDto> getAllHeat(@PageableDefault(size = 15) Pageable pageable) {
        var electricMeters = heatInfoRepository.findAll(pageable)
                .stream()
                .map(heatInfoMapper::toDto)
                .collect(Collectors.toList());
        return new PageImpl<>(electricMeters);
    }

    @GetMapping("/electric/export")
    public ResponseEntity<ByteArrayResource> exportToExcel() {
        var electricInfos = electricInfoRepository.findAll();
        var response = electricInfoExportService.exportEntities(electricTemplate, electricInfos);
        return ResponseEntity.ok()
                .headers(response.getHeaders())
                .body(response.getStream());
    }
}
