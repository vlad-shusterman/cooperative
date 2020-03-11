package by.bsuir.rest.contractor.controller;

import by.bsuir.repository.AuthorityRepository;
import by.bsuir.repository.ContractorRepository;
import by.bsuir.rest.contractor.mapper.AuthorityMapper;
import by.bsuir.rest.contractor.mapper.ContractorMapper;
import by.bsuir.rest.contractor.model.MainContractorDto;
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
@RequestMapping(value = "/api/contractors")
public class MainContractorController {
    private final ContractorRepository contractorRepository;
    private final AuthorityRepository authorityRepository;

    private final ContractorMapper contractorMapper;
    private final AuthorityMapper authorityMapper;

    @PostMapping
    public ResponseEntity<MainContractorDto> save(@RequestBody @Valid MainContractorDto mainContractorDto) {
        var contractors = mainContractorDto.getContractors()
                .stream()
                .map(contractorMapper::fromDto)
                .collect(Collectors.toList());

        var authorities = mainContractorDto.getAuthorities()
                .stream()
                .map(authorityMapper::fromDto)
                .collect(Collectors.toList());


        var savedContractors = contractorRepository.saveAll(contractors).stream()
                .map(contractorMapper::toDto).collect(Collectors.toList());

        var savedAuthorities = authorityRepository.saveAll(authorities).stream()
                .map(authorityMapper::toDto).collect(Collectors.toList());


        var result = MainContractorDto.builder()
                .contractors(savedContractors)
                .authorities(savedAuthorities)
                .build();

        return ResponseEntity.ok(result);
    }
}
