package by.bsuir.notification.entity;

import by.bsuir.notification.entity.enums.Assignee;
import by.bsuir.notification.entity.enums.ControlType;
import by.bsuir.notification.entity.enums.SendingType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Document(collection = "incoming_mail")
public class IncomingMail {

    @Id
    @MongoId(FieldType.OBJECT_ID)
    private String id;

    @Field
    private LocalDate receivingDate;

    @Field
    @NotNull
    private String addresser;

    @Field
    @Indexed(unique = true)
    @NotNull
    private String index;

    @Field
    private String topic;

    @Field
    private String text;

    @Field
    @NotNull
    private LocalDate registrationDate;

    @Field
    @NotNull
    private SendingType sendingType;

    @Field
    private ControlType controlType;

    @Field
    private Assignee assignee;
}
