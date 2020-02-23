package by.bsuir.registry.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotNull;

@Document(collection = "person")
@CompoundIndexes(
        @CompoundIndex(name = "fio", def = "{'name' : 1, 'surname': 1, 'lastName': 1}", unique = true)
)
public class Person {

    @Id
    @MongoId(value = FieldType.OBJECT_ID)
    private String id;
    @Field
    @NotNull
    private final String name;
    @Field
    @NotNull
    private final String surname;
    @Field
    @NotNull
    private final String lastName;
    @Field
    @NotNull
    private final String documentType;
    @Field
    private final PassportData passportData;

    private Person(@NotNull String name, @NotNull String surname, String lastName, @NotNull String documentType, PassportData passportData) {
        this.name = name;
        this.surname = surname;
        this.lastName = lastName;
        this.documentType = documentType;
        this.passportData = passportData;
    }

    @PersistenceConstructor
    public Person(@NotNull String id, @NotNull String name, @NotNull String surname, @NotNull String lastName, PassportData passportData, @NotNull String documentType) {
        this(name, surname, lastName, documentType, passportData);
        this.id = id;
    }

    public String getDocumentType() {
        return documentType;
    }

    public PassportData getPassportData() {
        return passportData;
    }

    public String getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public static final class PassportData {

        @Field
        @NotNull
        private final String number;
        @Field
        @NotNull
        private final long data;
        @Field
        @NotNull
        private final String issuingAuthority;
        @Field
        @NotNull
        private final String personalNumber;

        @PersistenceConstructor
        public PassportData(@NotNull String number, @NotNull long data, @NotNull String issuingAuthority, @NotNull String personalNumber) {
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
