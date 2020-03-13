package by.bsuir.model.entity;

import by.bsuir.model.common.Exportable;
import by.bsuir.model.entity.meter.ElectricMeter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = {"id", "value"})
@Document(collection = "electric_info")
public class ElectricInfo implements Exportable {

    @Id
    @MongoId(FieldType.OBJECT_ID)
    private String id;

    @DBRef
    @NotNull
    private ElectricMeter electricMeter;

    @Field
    @NotNull
    private Double value;

    @Field
    @NotNull
    private LocalDate readingDate;
}
