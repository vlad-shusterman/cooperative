package by.bsuir.rest.registry.model;

import by.bsuir.rest.registry.IDValidationGroup;
import by.bsuir.rest.registry.controller.CommunicationController;
import by.bsuir.rest.registry.controller.VicariousAuthorityController;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

public class PersonEntity {

    @Null
    @NotBlank(groups = IDValidationGroup.class)
    private final String id;
    @NotBlank
    private final String name;
    @NotBlank
    private final String surname;
    @NotBlank
    private final String lastName;
    @NotBlank
    private final String documentType;
    private final PassportData passportData;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public PersonEntity(
            @NotBlank(groups = IDValidationGroup.class) @Null @JsonProperty("id") String id,
            @NotBlank @JsonProperty("name") String name,
            @NotBlank @JsonProperty("surname") String surname,
            @NotBlank @JsonProperty("lastName") String lastName,
            @NotBlank @JsonProperty("documentType") String documentType,
            @JsonProperty("passportData") PassportData passportData
    ) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.lastName = lastName;
        this.documentType = documentType;
        this.passportData = passportData;
    }

    public PassportData getPassportData() {
        return passportData;
    }

    public String getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public String getCommunications() {
        // HateOas isn't work with swagger......
        return CommunicationController.class.getAnnotation(RequestMapping.class).value()[0] + "/person/" + id;
    }

    public String getIssuedVicariousAuthority() {
        // HateOas isn't work with swagger......
        return VicariousAuthorityController.class.getAnnotation(RequestMapping.class).value()[0] + "/proprietor/" + id;
    }

    public String getReceivedVicariousAuthority() {
        // HateOas isn't work with swagger......
        return VicariousAuthorityController.class.getAnnotation(RequestMapping.class).value()[0] + "/person/" + id;
    }

    public static final class PassportData {

        @NotBlank
        private final String number;
        @NotBlank
        private final long data;
        @NotBlank
        private final String issuingAuthority;
        @NotBlank
        private final String personalNumber;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        public PassportData(
                @NotBlank @JsonProperty("number") String number,
                @NotBlank @JsonProperty("data") long data,
                @NotBlank @JsonProperty("issuingAuthority") String issuingAuthority,
                @NotBlank @JsonProperty("personalNumber") String personalNumber
        ) {
            this.number = number;
            this.data = data;
            this.issuingAuthority = issuingAuthority;
            this.personalNumber = personalNumber;
        }

        public long getData() {
            return data;
        }

        public String getIssuingAuthority() {
            return issuingAuthority;
        }

        public String getNumber() {
            return number;
        }

        public String getPersonalNumber() {
            return personalNumber;
        }
    }

}
