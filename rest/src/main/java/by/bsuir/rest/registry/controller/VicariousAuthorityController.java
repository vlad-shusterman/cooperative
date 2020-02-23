package by.bsuir.rest.registry.controller;

import by.bsuir.registry.model.VicariousAuthority;
import by.bsuir.registry.service.VicariousAuthorityManager;
import by.bsuir.rest.mapper.EntityMapper;
import by.bsuir.rest.registry.model.VicariousAuthorityEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/vicarious/authority")
public class VicariousAuthorityController extends BaseController<VicariousAuthorityManager, VicariousAuthorityEntity, VicariousAuthority> {

    protected VicariousAuthorityController(VicariousAuthorityManager baseManager, EntityMapper<VicariousAuthorityEntity, VicariousAuthority> entityMapper) {
        super(baseManager, entityMapper);
    }

    @RequestMapping(
            path = "/person/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<VicariousAuthorityEntity>> byPersonId(@PathVariable("id") String personId, @RequestParam(value = "active", defaultValue = "false") boolean active) {
        if (active) {
            return ResponseEntity.ok(baseManager.findActiveByPersonId(personId).stream().map(entityMapper::toDto).collect(Collectors.toList()));
        } else {
            return ResponseEntity.ok(baseManager.findByPersonId(personId).stream().map(entityMapper::toDto).collect(Collectors.toList()));
        }
    }

    @RequestMapping(
            path = "/proprietor/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<VicariousAuthorityEntity>> ByProprietorId(@PathVariable("id") String proprietorId, @RequestParam(value = "active", defaultValue = "false") boolean active) {
        if (active) {
            return ResponseEntity.ok(baseManager.findActiveByProprietorId(proprietorId).stream().map(entityMapper::toDto).collect(Collectors.toList()));
        } else {
            return ResponseEntity.ok(baseManager.findByProprietorId(proprietorId).stream().map(entityMapper::toDto).collect(Collectors.toList()));
        }
    }

}
