package by.bsuir.model.entity.contractor;

import by.bsuir.model.common.Exportable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Document(collection = "contractor")

public class Contractor implements Exportable{

    @Id
    @MongoId(FieldType.OBJECT_ID)
    private String id;

    @Field
    @NotNull
    private ContractorType type;

    @Field
    @NotNull
    private String fullName;

    @Field
    @NotNull
    private String juridicalAccount;

    @Field
    @NotNull
    private String paymentAccount;

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
