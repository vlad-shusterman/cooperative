package by.bsuir.rest.contractor.controller;

import by.bsuir.repository.AuthorityRepository;
import by.bsuir.repository.ContractorRepository;
import by.bsuir.rest.contractor.mapper.AuthorityMapper;
import by.bsuir.rest.contractor.mapper.ContractorMapper;
import by.bsuir.rest.contractor.model.AuthorityDto;
import by.bsuir.rest.contractor.model.ContractorDto;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@Api
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/contractors/authority")
public class AuthorityController {
    private final AuthorityRepository authorityRepository;
    private final AuthorityMapper authorityMapper;

    @GetMapping
    public Page<AuthorityDto> getAll() {
        Pageable pageable = PageRequest.of(0, 15, Sort.by("registrationDate").ascending().and(Sort.by("fullName")).ascending());        var authorities = authorityRepository.findAll(pageable)
                .stream()
                .map(authorityMapper::toDto)
                .collect(Collectors.toList());
        return new PageImpl<>(authorities);
    }

    @PostMapping
    public ResponseEntity<AuthorityDto> save(@RequestBody AuthorityDto authorityDto) {
        authorityDto.setId(null);
        var entity = authorityMapper.fromDto(authorityDto);
        var savedAuthority = authorityRepository.save(entity);

        return ResponseEntity.ok(authorityMapper.toDto(savedAuthority));
    }


    @PutMapping("/{id}")
    public ResponseEntity<AuthorityDto> update(@PathVariable("id") String id,
                                                @RequestBody AuthorityDto authorityDto) {
        authorityDto.setId(id);
        var entity = authorityMapper.fromDto(authorityDto);
        var savedAuthority = authorityRepository.save(entity);

        return ResponseEntity.ok(authorityMapper.toDto(savedAuthority));
    }
}

