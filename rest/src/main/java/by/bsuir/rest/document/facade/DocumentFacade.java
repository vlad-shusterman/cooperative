package by.bsuir.rest.document.facade;

import by.bsuir.document.model.template.Tag;
import by.bsuir.rest.document.model.AgreementEntity;
import by.bsuir.rest.registry.model.VicariousAuthorityEntity;

import java.util.Map;

/**
 * @author Vladislav Novitskiy
 */
public interface DocumentFacade {
    void generateAgreement(String documentName, AgreementEntity data, String outputPath);

    void generateAttorney(String documentName, VicariousAuthorityEntity data, String outputPath);

    void generateDocument(String documentName, String templateName, Map<Tag.Param, String> paramValues, String outputPath);
}
