package by.bsuir.document.model.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotNull;

/**
 * @author Vladislav Novitskiy
 */
@Data
@Document(collection = "agreement")
public class Agreement {
    @Id
    @MongoId(value = FieldType.OBJECT_ID)
    private String id;

    @Field
    @NotNull
    @Indexed(unique = true)
    private String index;

    @Field
    @NotNull
    private String proprietorId;

    @Field
    @NotNull
    private String propertyId;
}
