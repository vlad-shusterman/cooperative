package by.bsuir.model.entity.contractor;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Document(collection = "authority")
public class Authority {
    @Id
    @MongoId(FieldType.OBJECT_ID)
    private String id;


    @Field
    @NotNull
    private String fullName;

    @Field
    @NotNull
    private String juridicalAccount;

    @Field
    @NotNull
    private String postAddress;

    @Field
    @NotNull
    private String headName;

    @Field
    @NotNull
    private String headPost;

    @Field
    @NotNull
    private LocalDate registrationDate;

    @Field
    private String description;
}
