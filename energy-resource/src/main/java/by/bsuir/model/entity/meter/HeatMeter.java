package by.bsuir.model.entity.meter;

import by.bsuir.model.common.Exportable;
import by.bsuir.registry.model.Person;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = {"id", "number"})
@Document(collection = "heat_meters")
public class HeatMeter implements Exportable {

    @Id
    @MongoId(value = FieldType.OBJECT_ID)
    private String id;

    @Field
    @NotNull
    private String number;

    @Field
    private Double value;

    @Field
    @NotNull
    private LocalDate readingDate;
    @DBRef
    private Person person;
}
