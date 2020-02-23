package model.entity.meter;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = {"id", "number"})
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "electric_meter")
public class ElectricMeter {
    @Id
    @MongoId(value = FieldType.OBJECT_ID)
    Long id;

    @Field
    @NotNull
    String number;

    @Field
    Double reading;

    @Field
    @NotNull
    LocalDate dateOfReading;

    @Field
    @NotNull
    Double transformationRatio;

    @Field
    LocalDate lastCheckDate;
}
