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
@Document(collection = "water_meters")
@CompoundIndexes({
        @CompoundIndex(name = "WaterMeter", def = "{'person': 1, 'waterMeterType': 1}", unique = true),
        @CompoundIndex(name = "WaterMeterNumber", def = "{'number': 1}", unique = true)
})
public class WaterMeter implements Exportable {

    @Id
    @MongoId(value = FieldType.OBJECT_ID)
    private String id;

    @Field
    @NotNull
    private String number;

    @Field
    @NotNull
    private WaterMeterType waterMeterType;

    @DBRef
    @NotNull
    private Person person;
}
