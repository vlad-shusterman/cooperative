package by.bsuir.rest.energy.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ElectricMeterDTO {

    @JsonProperty("id")
    @Null
    Long id;

    @JsonProperty("number")
    @NotBlank
    String number;

    @JsonProperty("reading")
    Double reading;

    @JsonProperty("dateOfReading")
    @NotNull
    LocalDate dateOfReading;

    @JsonProperty("transformationRatio")
    @NotNull
    Double transformationRatio;
}
