package by.bsuir.registry.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotNull;

@Document(collection = "vicarious_authority")
public class VicariousAuthority {

    @Id
    @MongoId(FieldType.OBJECT_ID)
    private String id;
    @Field
    @NotNull// From
    private final String proprietorId;
    @Field
    @NotNull // TimeUnit seconds since 1970....
    private final long startDate;
    @Field
    @NotNull // TimeUnit days
    private final long duration;
    @Field
    @NotNull// To
    private final String personId;

    private VicariousAuthority(@NotNull String proprietorId, @NotNull long startDate, @NotNull long duration, @NotNull String personId) {
        this.proprietorId = proprietorId;
        this.startDate = startDate;
        this.duration = duration;
        this.personId = personId;
    }

    @PersistenceConstructor
    public VicariousAuthority(@NotNull String id, @NotNull String proprietorId, @NotNull long startDate, @NotNull long duration, @NotNull String personId) {
        this(proprietorId, startDate, duration, personId);
        this.id = id;
    }

    public String getProprietorId() {
        return proprietorId;
    }

    public String getId() {
        return id;
    }

    public long getDuration() {
        return duration;
    }

    public long getStartDate() {
        return startDate;
    }

    public String getPersonId() {
        return personId;
    }

}
