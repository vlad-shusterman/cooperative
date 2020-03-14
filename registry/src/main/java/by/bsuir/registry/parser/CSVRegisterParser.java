package by.bsuir.registry.parser;

import by.bsuir.registry.model.Communication;
import by.bsuir.registry.model.Person;
import by.bsuir.registry.model.Property;
import by.bsuir.registry.service.CommunicationManager;
import by.bsuir.registry.service.PersonManager;
import by.bsuir.registry.service.PropertyManager;
import com.google.common.base.Charsets;
import com.mongodb.DuplicateKeyException;
import com.mongodb.lang.Nullable;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class CSVRegisterParser {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

    private final PersonManager personManager;
    private final PropertyManager propertyManager;
    private final CommunicationManager communicationManager;

    public CSVRegisterParser(PersonManager personManager, PropertyManager propertyManager, CommunicationManager communicationManager) {
        this.personManager = personManager;
        this.propertyManager = propertyManager;
        this.communicationManager = communicationManager;
    }

    public final void restoreFromSource(Resource resource) throws IOException {
        for (CSVRow row : CSVParser.parse(new InputStreamReader(resource.getInputStream(), Charsets.UTF_8))) {
            try {
                Person person = restorePerson(row);
                Person storedPerson = null;
                if (person != null) {
                    List<Communication> communications = restoreCommunications(row);

                    try {
                        storedPerson = personManager.register(person);
                    } catch (DuplicateKeyException e) {
                        storedPerson = personManager.find(testPerson -> personManager.getFullName(testPerson).equals(personManager.getFullName(person))).stream().findFirst().orElseThrow();
                    }

                    for (Communication communication : communications) {
                        communication.setPersonId(storedPerson.getId());
                        ignoreAnyException(() -> communicationManager.register(communication));
                    }
                }

                Property property = restoreProperty(row, storedPerson);
                if (property != null) {
                    Property storedProperty;
                    try {
                        storedProperty = propertyManager.register(property);
                    } catch (DuplicateKeyException e) {
                        storedProperty = propertyManager.find(testProperty -> testProperty.getInventoryNumber().equals(property.getInventoryNumber())).stream().findFirst().orElseThrow();
                        storedProperty = propertyManager.update(
                                new Property(
                                        storedProperty.getId(),
                                        storedProperty.getInventoryNumber(),
                                        storedProperty.getSquare(),
                                        storedProperty.getOwners(),
                                        storedProperty.getHistoryOwners(),
                                        storedProperty.getPtn()
                                )
                        );
                    }
                }
            } catch (RuntimeException ignore) {
            }
        }
    }

    private static Person restorePerson(CSVRow csvRow) {
        Person person = new Person();
        CSVCell fio = csvRow.getByName("FAMILY");
        if (StringUtils.isBlank(fio.getCellValue())) {
            return null;
        }
        String[] splitFio = fio.getCellValue().split(" ");
        person.setName(splitFio.length > 0 ? splitFio[0] : "");
        person.setSurname(splitFio.length > 1 ? splitFio[1] : "");
        person.setLastName(splitFio.length > 2 ? splitFio[2] : "");

        CSVCell documentType = csvRow.getByName("VIDDOKA");
        if (StringUtils.isNotBlank(documentType.getCellValue())) {
            person.setDocumentType(documentType.getCellValue());
            Person.PassportData passportData = new Person.PassportData();

            passportData.setIssuingAuthority(csvRow.getByName("PW").getCellValue());
            passportData.setPersonalNumber(csvRow.getByName("PN").getCellValue());
            passportData.setNumber(csvRow.getByName("PASP").getCellValue());
            passportData.setData(getUnixTime(csvRow.getByName("PD").getCellValue()));
            if (StringUtils.isNotBlank(passportData.getIssuingAuthority()) || StringUtils.isNotBlank(passportData.getPersonalNumber())
                    || StringUtils.isNotBlank(passportData.getNumber()) || passportData.getData() != 0L) {
                person.setPassportData(passportData);
            }
        }
        person.setLivingAddress(csvRow.getByName("ADDRESS").getCellValue());
        return person;
    }

    private static Property restoreProperty(CSVRow csvRow, Person storedPerson) {
        if (StringUtils.isAnyBlank(csvRow.getByName("INV").getCellValue(), csvRow.getByName("BOX_SQ").getCellValue())) {
            return null;
        }
        List<Property.PropertyOwner> owners = new ArrayList<>();
        if (storedPerson != null) {
            owners.add(new Property.PropertyOwner(
                    storedPerson.getId(),
                    getUnixTime(csvRow.getByName("DATE_REG").getCellValue()),
                    Double.parseDouble(csvRow.getByName("GV").getCellValue().replace(",", ".")),
                    csvRow.getByName("NUM").getCellValue()
            ));
        }
        return new Property(
                csvRow.getByName("INV").getCellValue(),
                csvRow.getByName("%FIO%").getCellValue(),
                Double.parseDouble(csvRow.getByName("BOX_SQ").getCellValue().replace(",", ".")),
                owners,
                Collections.emptyList()
        );
    }

    private static List<Communication> restoreCommunications(CSVRow csvRow) {
        return add(
                add(
                        add(
                                add(
                                        add(
                                                new ArrayList<>(),
                                                restoreCommunication(csvRow, "PHONE", "mobilePhone")
                                        ),
                                        restoreCommunication(csvRow, "MAIL", "email")
                                ),
                                restoreCommunication(csvRow, "VIBER", "viber")
                        ),
                        restoreCommunication(csvRow, "TELEG", "telegram")
                ),
                restoreCommunication(csvRow, "WHATS", "whatsapp")
        );
    }

    private static Communication restoreCommunication(CSVRow csvRow, String column, String type) {
        CSVCell cell = csvRow.getByName(column);
        if (StringUtils.isNotBlank(cell.getCellValue())) {
            Communication communication = new Communication();
            communication.setCommunicationType(type);
            communication.setCommunicationValue(cell.getCellValue());
            return communication;
        }
        return null;
    }

    private static <T> List<T> add(List<T> list, @Nullable T t) {
        if (t == null) {
            return list;
        }
        list.add(t);
        return list;
    }

    private static void ignoreAnyException(Runnable runnable) {
        try {
            runnable.run();
        } catch (RuntimeException ignore) {

        }
    }

    private static long getUnixTime(String data) {
        if (StringUtils.isBlank(data)) {
            return 0L;
        }
        try {
            Date date = DATE_FORMAT.parse(data);
            return TimeUnit.MILLISECONDS.toSeconds(date.getTime());
        } catch (ParseException ignore) {
        }
        return 0L;
    }

}
