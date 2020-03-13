package by.bsuir.model.entity.meter;

import by.bsuir.model.common.Exportable;
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
@Document(collection = "heat_meters")
@CompoundIndexes({
        @CompoundIndex(name = "HeatMeter", def = "{'person': 1, 'number': 1}", unique = true),
        @CompoundIndex(name = "HeatMeterNumber", def = "{'number': 1}", unique = true)
})
public class HeatMeter implements Exportable {

    @Id
    @MongoId(value = FieldType.OBJECT_ID)
    private String id;

    @Field
    @NotNull
    private String number;

    @DBRef
    @NotNull
    private Person person;
}
