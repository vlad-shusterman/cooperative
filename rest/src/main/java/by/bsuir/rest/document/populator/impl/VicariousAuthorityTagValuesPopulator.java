package by.bsuir.rest.document.populator.impl;

import by.bsuir.document.TagType;
import by.bsuir.document.service.dellayformat.DelayFormatService;
import by.bsuir.registry.service.PersonManager;
import by.bsuir.registry.service.VicariousAuthorityManager;
import by.bsuir.rest.document.populator.DataPopulator;
import by.bsuir.rest.registry.model.VicariousAuthorityEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Vladislav Novitskiy
 */
@AllArgsConstructor
@Component
public class VicariousAuthorityTagValuesPopulator implements DataPopulator<VicariousAuthorityEntity, Map<String, Object>> {
    private PersonManager personManager;
    private DelayFormatService delayFormatService;
    private VicariousAuthorityManager vicariousAuthorityManager;

    @Override
    public void populate(VicariousAuthorityEntity vicariousAuthorityEntity, Map<String, Object> stringObjectMap) {
        // TODO Write all tags real processing when finished requisites

        stringObjectMap.put(TagType.PARTNERSHIP.getValue(), "1");
        stringObjectMap.put(TagType.PAN.getValue(), "1");
        stringObjectMap.put(TagType.PRESIDENT.getValue(), "1");
        stringObjectMap.put(TagType.FAMILY.getValue(), personManager.find(vicariousAuthorityEntity.getProprietorId()));
        stringObjectMap.put(TagType.FAMILY_TO.getValue(), personManager.find(vicariousAuthorityEntity.getPersonId()));
        stringObjectMap.put(TagType.ATP.getValue(), delayFormatService.formatDelay(
                vicariousAuthorityEntity.getStartDate(), vicariousAuthorityEntity.getDuration()));
        stringObjectMap.put(TagType.AN.getValue(), vicariousAuthorityManager.find(vicariousAuthorityEntity.getId()));
    }
}
