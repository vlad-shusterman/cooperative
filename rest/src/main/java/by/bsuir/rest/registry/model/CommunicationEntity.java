package by.bsuir.rest.registry.model;

import by.bsuir.rest.registry.IDValidationGroup;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

public class CommunicationEntity {

    @Null
    @NotBlank(groups = IDValidationGroup.class)
    private final String id;
    @NotBlank
    private final String personId;
    @NotBlank
    private final String communicationType;
    @NotBlank
    private final String communicationValue;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CommunicationEntity(
            @JsonProperty("id") @NotBlank(groups = IDValidationGroup.class) @Null String id,
            @JsonProperty("personId") @NotBlank String personId,
            @JsonProperty("communicationType") @NotBlank String communicationType,
            @JsonProperty("communicationValue") @NotBlank String communicationValue
    ) {
        this.id = id;
        this.personId = personId;
        this.communicationType = communicationType;
        this.communicationValue = communicationValue;
    }

    public String getId() {
        return id;
    }

    public String getCommunicationType() {
        return communicationType;
    }

    public String getCommunicationValue() {
        return communicationValue;
    }

    public String getPersonId() {
        return personId;
    }

}
