package by.bsuir.rest.document.populator.impl;

import by.bsuir.document.model.template.Tag;
import by.bsuir.rest.document.model.AgreementEntity;
import by.bsuir.rest.document.populator.DataPopulator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

import static by.bsuir.document.model.template.Tag.Param.*;

/**
 * @author Vladislav Novitskiy
 */
@AllArgsConstructor
@Component
public class AgreementTagValuesPopulator implements DataPopulator<AgreementEntity, Map<Tag.Param, String>> {

    @Override
    public void populate(AgreementEntity agreementEntity, Map<Tag.Param, String> paramStringMap) {
        paramStringMap.put(ID, agreementEntity.getId());
        paramStringMap.put(PERSON_ID, agreementEntity.getProprietorId());
        paramStringMap.put(INDEX, agreementEntity.getIndex());
        paramStringMap.put(PROPERTY_ID, agreementEntity.getPropertyId());
    }
}
