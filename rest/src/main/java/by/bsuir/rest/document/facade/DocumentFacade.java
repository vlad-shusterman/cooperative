package by.bsuir.rest.document.facade;

import by.bsuir.rest.document.dto.AgreementData;
import by.bsuir.rest.registry.model.VicariousAuthorityEntity;

/**
 * @author Vladislav Novitskiy
 */
public interface DocumentFacade {
    void generateAgreement(AgreementData data, String outputPath);

    void generateAttorney(VicariousAuthorityEntity data, String outputPath);
}
