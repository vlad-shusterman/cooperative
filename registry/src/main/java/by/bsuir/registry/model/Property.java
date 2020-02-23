package by.bsuir.registry.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Document(collection = "property")
public class Property {

    @Id
    @MongoId(FieldType.OBJECT_ID)
    private String id;

    @Field
    @NotNull
    @Indexed(unique = true)
    private final String inventoryNumber;

    @Field
    @NotNull
    private final double square;

    @Field
    @NotNull
    private final List<PropertyOwner> owners;

    @Field
    @NotNull
    private final List<HistoryPropertyOwner> historyOwners;

    private Property(@NotNull String inventoryNumber, @NotNull double square, @NotNull Collection<PropertyOwner> owners, @NotNull Collection<HistoryPropertyOwner> historyOwners) {
        this.inventoryNumber = inventoryNumber;
        this.square = square;
        this.owners = List.copyOf(owners);
        this.historyOwners = List.copyOf(historyOwners);
    }

    @PersistenceConstructor
    public Property(@NotNull String id, @NotNull String inventoryNumber, @NotNull double square, @NotNull Collection<PropertyOwner> owners, @NotNull Collection<HistoryPropertyOwner> historyOwners) {
        this(inventoryNumber, square, owners, historyOwners);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Collection<HistoryPropertyOwner> getHistoryOwners() {
        return Collections.unmodifiableCollection(historyOwners);
    }

    public Collection<PropertyOwner> getOwners() {
        return Collections.unmodifiableCollection(owners);
    }

    public double getSquare() {
        return square;
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public static class PropertyOwner {
        @Field
        @NotNull
        private final String personId;

        @Field
        @NotNull
        private final long startDate;

        @Field
        @NotNull
        private final double owningPercent;

        @PersistenceConstructor
        public PropertyOwner(@NotNull String personId, @NotNull long startDate, @NotNull double owningPercent) {
            this.personId = personId;
            this.startDate = startDate;
            this.owningPercent = owningPercent;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PropertyOwner)) return false;
            PropertyOwner that = (PropertyOwner) o;
            return getStartDate() == that.getStartDate() &&
                    Double.compare(that.getOwningPercent(), getOwningPercent()) == 0 &&
                    Objects.equals(getPersonId(), that.getPersonId());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getPersonId(), getStartDate(), getOwningPercent());
        }

        public String getPersonId() {
            return personId;
        }

        public long getStartDate() {
            return startDate;
        }

        public double getOwningPercent() {
            return owningPercent;
        }
    }

    public static class HistoryPropertyOwner extends PropertyOwner {

        @Field
        @NotNull
        private final long endDate;

        @PersistenceConstructor
        public HistoryPropertyOwner(@NotNull String personId, @NotNull long startDate, @NotNull double owningPercent, @NotNull long endDate) {
            super(personId, startDate, owningPercent);
            this.endDate = endDate;
        }

        public long getEndDate() {
            return endDate;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof HistoryPropertyOwner)) return false;
            if (!super.equals(o)) return false;
            HistoryPropertyOwner that = (HistoryPropertyOwner) o;
            return getEndDate() == that.getEndDate();
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), getEndDate());
        }
    }

}
