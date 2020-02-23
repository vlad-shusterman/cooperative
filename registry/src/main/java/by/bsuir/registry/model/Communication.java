package by.bsuir.registry.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.validation.constraints.NotNull;

@Document(collection = "communication")
@ParametersAreNonnullByDefault
@CompoundIndexes(
        @CompoundIndex(name = "communication_index", def = "{'personId' : 1, 'communicationType': 1, 'communicationValue': 1}", unique = true)
)
public class Communication {

    @Id
    @MongoId(FieldType.OBJECT_ID)
    private String id;

    @Field
    @NotNull
    private final String personId;

    // Enum?
    @Field
    @NotNull
    private final String communicationType;

    @Field
    @NotNull
    private final String communicationValue;

    @PersistenceConstructor
    public Communication(String id, String personId, String communicationType, String communicationValue) {
        this(personId, communicationType, communicationValue);
        this.id = id;
    }

    private Communication(String personId, String communicationType, String communicationValue) {
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
