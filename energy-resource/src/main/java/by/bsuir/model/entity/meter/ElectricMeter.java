package by.bsuir.model.entity.meter;

import by.bsuir.registry.model.Person;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.*;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(of = {"id", "number"})
@Document(collection = "electric_meters")
@CompoundIndexes({
        @CompoundIndex(name = "ElectricMeter", def = "{'person': 1, 'number': 1}", unique = true),
        @CompoundIndex(name = "ElectricMeterNumber", def = "{'number': 1}", unique = true)
})
public class ElectricMeter {

    @Id
    @MongoId(FieldType.OBJECT_ID)
    private String id;

    @Field
    @NotNull
    private String number;

    @Field
    @NotNull
    private Double transformationRatio;

    @DBRef
    @NotNull
    private Person person;
}
