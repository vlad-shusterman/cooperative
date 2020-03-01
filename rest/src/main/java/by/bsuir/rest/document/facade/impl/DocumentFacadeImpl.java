package by.bsuir.rest.document.facade.impl;

import by.bsuir.document.TemplateType;
import by.bsuir.registry.model.VicariousAuthority;
import by.bsuir.registry.service.VicariousAuthorityManager;
import by.bsuir.rest.document.dto.AgreementData;
import by.bsuir.rest.document.facade.DocumentFacade;
import by.bsuir.rest.document.populator.impl.AgreementTagValuesPopulator;
import by.bsuir.rest.document.populator.impl.VicariousAuthorityTagValuesPopulator;
import by.bsuir.document.service.document.DocumentService;
import by.bsuir.rest.registry.mapper.VicariousAuthorityEntityMapper;
import by.bsuir.rest.registry.model.VicariousAuthorityEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vladislav Novitskiy
 */
@AllArgsConstructor
@Component
public class DocumentFacadeImpl implements DocumentFacade {
    private AgreementTagValuesPopulator agreementTagValuesPopulator;
    private VicariousAuthorityTagValuesPopulator vicariousAuthorityTagValuesPopulator;
    private DocumentService documentService;
    private VicariousAuthorityManager vicariousAuthorityManager;
    private VicariousAuthorityEntityMapper vicariousAuthorityEntityMapper;

    @Override
    public void generateAgreement(AgreementData data, String outputPath) {
        Map<String, Object> tagValues = new HashMap<>();
        agreementTagValuesPopulator.populate(data, tagValues);
        documentService.generate(TemplateType.AGREEMENT, tagValues, outputPath);
    }

    @Override
    public void generateAttorney(VicariousAuthorityEntity data, String outputPath) {
        Map<String, Object> tagValues = new HashMap<>();
        VicariousAuthority saved = vicariousAuthorityManager.register(vicariousAuthorityEntityMapper.fromDto(data));
        vicariousAuthorityTagValuesPopulator.populate(vicariousAuthorityEntityMapper.toDto(saved), tagValues);
        documentService.generate(TemplateType.VICARIOUS_AUTHORITY, tagValues, outputPath);
    }
}
