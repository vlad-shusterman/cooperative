package by.bsuir.model.entity;

import by.bsuir.model.entity.meter.WaterMeter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = {"id", "value"})
@Document(collection = "water_info")
public class WaterInfo {

    @Id
    @MongoId(FieldType.OBJECT_ID)
    private String id;

    @DBRef
    @NotNull
    private WaterMeter waterMeter;

    @Field
    @NotNull
    private Double value;

    @Field
    @NotNull
    private LocalDate readingDate;
}
