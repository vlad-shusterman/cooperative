package by.bsuir.rest.energy.controller;

import by.bsuir.repository.ElectricMeterRepository;
import by.bsuir.repository.HeatMeterRepository;
import by.bsuir.repository.WaterMeterRepository;
import by.bsuir.rest.energy.mapper.ElectricMeterMapper;
import by.bsuir.rest.energy.mapper.HeatMeterMapper;
import by.bsuir.rest.energy.mapper.WaterMeterMapper;
import by.bsuir.rest.energy.model.EnergyMeterDto;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Api
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/energy/meters")
public class EnergyMeterController {

    private final ElectricMeterMapper electricMeterMapper;
    private final WaterMeterMapper waterMeterMapper;
    private final HeatMeterMapper heatMeterMapper;

    private final ElectricMeterRepository electricMeterRepository;
    private final HeatMeterRepository heatMeterRepository;
    private final WaterMeterRepository waterMeterRepository;

    //    private final ExportService exportService;

    @PostMapping
    public ResponseEntity<EnergyMeterDto> save(@RequestBody @Valid EnergyMeterDto energyMeterDTO) {
        var electricMeters = energyMeterDTO.getElectricMeters()
                .stream()
                .map(electricMeterMapper::fromDto)
                .collect(Collectors.toList());

        var waterMeters = energyMeterDTO.getWaterMeters()
                .stream()
                .map(waterMeterMapper::fromDto)
                .collect(Collectors.toList());

        var heatMeters = energyMeterDTO.getHeatMeters()
                .stream()
                .map(heatMeterMapper::fromDto)
                .collect(Collectors.toList());

        var savedElectricMeters = electricMeterRepository.saveAll(electricMeters).stream()
                .map(electricMeterMapper::toDto).collect(Collectors.toList());

        var savedHeatMeters = heatMeterRepository.saveAll(heatMeters).stream()
                .map(heatMeterMapper::toDto).collect(Collectors.toList());

        var savedWaterMeters = waterMeterRepository.saveAll(waterMeters).stream()
                .map(waterMeterMapper::toDto).collect(Collectors.toList());

        var result = EnergyMeterDto.builder()
                .electricMeters(savedElectricMeters)
                .heatMeters(savedHeatMeters)
                .waterMeters(savedWaterMeters)
                .build();

        return ResponseEntity.ok(result);
    }
}

