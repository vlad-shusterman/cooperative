package by.bsuir.rest.energy.controller;

import by.bsuir.rest.energy.mapper.ElectricMeterMapper;
import by.bsuir.rest.energy.mapper.HeatMeterMapper;
import by.bsuir.rest.energy.mapper.WaterMeterMapper;
import by.bsuir.rest.energy.model.EnergyMeterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/energy/meters")
public class EnergyMeterController {

    private ElectricMeterMapper electricMeterMapper;
    private WaterMeterMapper waterMeterMapper;
    private HeatMeterMapper heatMeterMapper;

    @PostMapping("/save")
    public ResponseEntity save(@Valid EnergyMeterDTO energyMeterDTO) {
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

        // TODO: create energy meter services and save this entities

        return new ResponseEntity(HttpStatus.OK);
    }
}

