package by.bsuir.document.model.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotNull;

/**
 * @author Vladislav Novitskiy
 */
@Data
@org.springframework.data.mongodb.core.mapping.Document(collection = "document")
public class Document {
    @Id
    @MongoId(value = FieldType.OBJECT_ID)
    private String id;

    @Field
    @NotNull
    private String name;

    @Field
    @NotNull
    @Indexed(unique = true)
    private String path;

    @Field
    @NotNull
    private String templateId;
}
