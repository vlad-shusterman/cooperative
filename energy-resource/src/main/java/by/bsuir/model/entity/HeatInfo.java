package by.bsuir.model.entity;

import by.bsuir.model.entity.meter.HeatMeter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = {"id", "value"})
@Document(collection = "heat_info")
public class HeatInfo {

    @Id
    @MongoId(FieldType.OBJECT_ID)
    private String id;

    @DBRef
    @NotNull
    private HeatMeter heatMeter;

    @Field
    @NotNull
    private Double value;

    @Field
    @NotNull
    private LocalDate readingDate;
}
