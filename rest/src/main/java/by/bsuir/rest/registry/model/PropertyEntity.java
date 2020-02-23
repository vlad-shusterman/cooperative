package by.bsuir.rest.registry.model;

import by.bsuir.rest.registry.IDValidationGroup;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;

import javax.validation.constraints.DecimalMin;
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
    @DecimalMin(value = "0.0", inclusive = false)
    private final double square;
    private final ImmutableList<PropertyOwner> owners;
    private final ImmutableList<HistoryPropertyOwner> historyOwners;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public PropertyEntity(
            @NotBlank(groups = IDValidationGroup.class) @Null @JsonProperty("id") String id,
            @NotBlank @JsonProperty("inventoryNumber") String inventoryNumber,
            @DecimalMin(value = "0.0", inclusive = false) @JsonProperty("square") double square,
            @JsonProperty("owners") Collection<PropertyOwner> owners,
            @JsonProperty(value = "historyOwners") Collection<HistoryPropertyOwner> historyPropertyOwners
    ) {
        this.id = id;
        this.inventoryNumber = inventoryNumber;
        this.square = square;
        this.owners = owners == null ? ImmutableList.of() : ImmutableList.copyOf(owners);
        this.historyOwners = historyPropertyOwners == null ? ImmutableList.of() : ImmutableList.copyOf(historyPropertyOwners);
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
        @DecimalMin(value = "0.0", inclusive = false)
        @DecimalMin(value = "1.0")
        private final double owningPercent;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        public PropertyOwner(
                @NotBlank @JsonProperty("personId") String personId,
                @NotNull @JsonProperty("startDate") long startDate,
                @DecimalMin(value = "0.0", inclusive = false) @DecimalMin(value = "1.0") @JsonProperty("owningPercent") double owningPercent
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

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        public HistoryPropertyOwner(
                @JsonProperty("personId") String personId,
                @JsonProperty("startDate") long startDate,
                @JsonProperty("owningPercent") double owningPercent,
                @JsonProperty("endDate") long endDate
        ) {
            super(personId, startDate, owningPercent);
            this.endDate = endDate;
        }

        public long getEndDate() {
            return endDate;
        }

    }

}
