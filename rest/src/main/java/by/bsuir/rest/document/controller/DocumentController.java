package by.bsuir.rest.document.controller;

import by.bsuir.document.model.template.Tag;
import by.bsuir.rest.document.model.AgreementEntity;
import by.bsuir.rest.document.facade.DocumentFacade;
import by.bsuir.rest.registry.IDValidationGroup;
import by.bsuir.rest.registry.model.VicariousAuthorityEntity;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Controller to work with physical documents and its virtual representation
 * as {@link by.bsuir.document.model.document.Document} entities.
 *
 * @author Vladislav Novitskiy
 */
@AllArgsConstructor
@RestController
@RequestMapping("/api/document")
public class DocumentController {
    private DocumentFacade documentFacade;

    /**
     * Method generates agreement doc.
     *
     * @param data Data for generation this type of document
     * @param name Name of generated agreement {@link by.bsuir.document.model.document.Document} in system
     * @param path Path to saving file
     * @return Void ok response
     */
    @PostMapping("/agreement")
    public ResponseEntity<Void> generateAgreement(
            @RequestBody @Validated(value = IDValidationGroup.class) AgreementEntity data,
            @RequestParam String name, @RequestParam String path) {
        documentFacade.generateAgreement(name, data, path);
        return ResponseEntity.ok().build();
    }

    /**
     * Method generates attorney doc.
     *
     * @param data Data for generation this type of document
     * @param name Name of generated attorney {@link by.bsuir.document.model.document.Document} in system
     * @param path Path to saving file
     * @return Void ok response
     */
    @PostMapping("/attorney")
    public ResponseEntity<Void> generateAttorney(
            @RequestBody @Validated(IDValidationGroup.class) VicariousAuthorityEntity data,
            @RequestParam String name, @RequestParam String path) {
        documentFacade.generateAttorney(name, data, path);
        return ResponseEntity.ok().build();
    }

    /**
     * Method generate custom doc.
     *
     * @param paramValues  {@link Map} with params for tags and their values
     * @param path         Path to saving file
     * @param name         Name of generated custom {@link by.bsuir.document.model.document.Document} in system
     * @param templateName Name of used template
     * @return Void ok response
     */
    @PostMapping("/custom")
    public ResponseEntity<Void> generateCustomDocument(@RequestBody Map<Tag.Param, String> paramValues,
                                                       @RequestParam String path, @RequestParam String name,
                                                       @RequestParam String templateName) {
        documentFacade.generateDocument(name, templateName, paramValues, path);
        return ResponseEntity.ok().build();
    }
}
