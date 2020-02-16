package by.bsuir.rest.registry.model;

import by.bsuir.rest.registry.IDValidationGroup;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Collection;

public class PropertyEntity {

    @NotBlank(groups = IDValidationGroup.class)
    @Null
    private final String id;
    @NotBlank
    private final String inventoryNumber;
    @NotNull
    private final double square;
    private final ImmutableList<PropertyOwner> owners;
    private final ImmutableList<HistoryPropertyOwner> historyOwners;

    public PropertyEntity(@NotBlank(groups = IDValidationGroup.class) @Null String id, @NotBlank String inventoryNumber, @NotNull double square, Collection<PropertyOwner> owners, Collection<HistoryPropertyOwner> historyOwners) {
        this.id = id;
        this.inventoryNumber = inventoryNumber;
        this.square = square;
        this.owners = ImmutableList.copyOf(owners);
        this.historyOwners = ImmutableList.copyOf(historyOwners);
    }

    @JsonCreator
    public PropertyEntity(
            @JsonProperty("id") @NotBlank(groups = IDValidationGroup.class) @Null String id,
            @JsonProperty("inventoryNumber") @NotBlank String inventoryNumber,
            @JsonProperty("square") @NotNull double square,
            @JsonProperty("owners") Collection<PropertyOwner> owners
    ) {
        this.id = id;
        this.inventoryNumber = inventoryNumber;
        this.square = square;
        this.owners = ImmutableList.copyOf(owners);
        this.historyOwners = ImmutableList.of();
    }

    public String getId() {
        return id;
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public double getSquare() {
        return square;
    }

    public Collection<HistoryPropertyOwner> getHistoryOwners() {
        return historyOwners;
    }

    public Collection<PropertyOwner> getOwners() {
        return owners;
    }

    public static class PropertyOwner {
        @NotBlank
        private final String personId;
        @NotNull
        private final long startDate;
        @NotNull
        private final double owningPercent;

        @JsonCreator
        public PropertyOwner(
                @JsonProperty("personId") @NotBlank String personId,
                @JsonProperty("startDate") @NotNull long startDate,
                @JsonProperty("owningPercent") @NotNull double owningPercent
        ) {
            this.personId = personId;
            this.startDate = startDate;
            this.owningPercent = owningPercent;
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
        private final long endDate;

        public HistoryPropertyOwner(
                String personId,
                long startDate,
                double owningPercent,
                long endDate
        ) {
            super(personId, startDate, owningPercent);
            this.endDate = endDate;
        }

        public long getEndDate() {
            return endDate;
        }

    }

}
