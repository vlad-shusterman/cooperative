package by.bsuir.rest.document.populator.impl;

import by.bsuir.document.model.template.Tag;
import by.bsuir.rest.document.populator.DataPopulator;
import by.bsuir.rest.registry.model.VicariousAuthorityEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

import static by.bsuir.document.model.template.Tag.Param.*;

/**
 * @author Vladislav Novitskiy
 */
@AllArgsConstructor
@Component
public class VicariousAuthorityTagValuesPopulator implements DataPopulator<VicariousAuthorityEntity, Map<Tag.Param, String>> {

    @Override
    public void populate(VicariousAuthorityEntity vicariousAuthorityEntity, Map<Tag.Param, String> paramStringMap) {
        paramStringMap.put(ID, vicariousAuthorityEntity.getId());
        paramStringMap.put(PERSON_ID, vicariousAuthorityEntity.getProprietorId());
        paramStringMap.put(TO_PERSON_ID, vicariousAuthorityEntity.getPersonId());
        paramStringMap.put(START_DATE, String.valueOf(vicariousAuthorityEntity.getStartDate()));
        paramStringMap.put(DURATION, String.valueOf(vicariousAuthorityEntity.getDuration()));
    }
}
