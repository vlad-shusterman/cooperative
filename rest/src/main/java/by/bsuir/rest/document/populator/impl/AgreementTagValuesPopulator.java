package by.bsuir.rest.document.populator.impl;

import by.bsuir.document.TagType;
import by.bsuir.registry.model.Person;
import by.bsuir.registry.model.Property;
import by.bsuir.registry.service.PersonManager;
import by.bsuir.registry.service.PropertyManager;
import by.bsuir.rest.document.dto.AgreementData;
import by.bsuir.rest.document.exception.EntityNotFoundException;
import by.bsuir.rest.document.populator.DataPopulator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * @author Vladislav Novitskiy
 */
@AllArgsConstructor
@Component
public class AgreementTagValuesPopulator implements DataPopulator<AgreementData, Map<String, Object>> {
    private PersonManager personManager;
    private PropertyManager propertyManager;
    private DateTimeFormatter dateTimeFormatter;

    @Override
    public void populate(AgreementData agreementData, Map<String, Object> tagTypeObjectMap) {
        // TODO Write all tags real processing when finished requisites

        tagTypeObjectMap.put(TagType.PRESIDENT.getValue(), "1");
        tagTypeObjectMap.put(TagType.PAN.getValue(), "1");
        tagTypeObjectMap.put(TagType.IND_DOG.getValue(), "1");
        tagTypeObjectMap.put(TagType.PARTNERSHIP.getValue(), "1");
        tagTypeObjectMap.put(TagType.INDEX.getValue(), "1");

        Person person = personManager.find(agreementData.getOwnerId());
        if (person == null) {
            throw new EntityNotFoundException("No owner with id '" + agreementData.getOwnerId() + "'");
        }

        tagTypeObjectMap.put(TagType.FAMILY.getValue(), personManager.getFullName(person));
        tagTypeObjectMap.put(TagType.ADDRESS.getValue(), "1");
        tagTypeObjectMap.put(TagType.PHONE.getValue(), "1");
        tagTypeObjectMap.put(TagType.MAIL.getValue(), "1");

        Person.PassportData passportData = person.getPassportData();
        tagTypeObjectMap.put(TagType.PASP.getValue(), passportData.getNumber());
        tagTypeObjectMap.put(TagType.PW.getValue(), passportData.getIssuingAuthority());
        tagTypeObjectMap.put(TagType.PD.getValue(), dateTimeFormatter.format(LocalDate.ofEpochDay(
                passportData.getData())));
        tagTypeObjectMap.put(TagType.PN.getValue(), passportData.getPersonalNumber());

        Property property = propertyManager.find(agreementData.getPropertyId());
        if (property == null) {
            throw new EntityNotFoundException("No property with id '" + agreementData.getPropertyId() + "'");
        }

        tagTypeObjectMap.put(TagType.FIO.getValue(), "1");
        tagTypeObjectMap.put(TagType.BOX_SQ.getValue(), property.getSquare());
        tagTypeObjectMap.put(TagType.NUM.getValue(), "1");
        tagTypeObjectMap.put(TagType.DATE_REG.getValue(), "1");
        tagTypeObjectMap.put(TagType.INV.getValue(), property.getInventoryNumber());
    }
}
