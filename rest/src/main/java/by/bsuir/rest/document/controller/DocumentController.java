package by.bsuir.rest.document.controller;

import by.bsuir.rest.document.dto.AgreementData;
import by.bsuir.rest.document.facade.DocumentFacade;
import by.bsuir.rest.registry.IDValidationGroup;
import by.bsuir.rest.registry.model.VicariousAuthorityEntity;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
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
     * @param path Path to saving file
     * @return Void ok response
     */
    @PostMapping("/agreement")
    public ResponseEntity<Void> generateAgreement(
            @RequestBody @Validated(value = IDValidationGroup.class) AgreementData data, @RequestParam String path) {
        documentFacade.generateAgreement(data, path);
        return ResponseEntity.ok().build();
    }

    /**
     * Method generates attorney doc.
     *
     * @param data Data for generation this type of document
     * @param path Path to saving file
     * @return Void ok response
     */
    @PostMapping("/attorney")
    public ResponseEntity<Void> generateAttorney(
            @RequestBody @Validated(IDValidationGroup.class) VicariousAuthorityEntity data, @RequestParam String path) {
        documentFacade.generateAttorney(data, path);
        return ResponseEntity.ok().build();
    }
}
