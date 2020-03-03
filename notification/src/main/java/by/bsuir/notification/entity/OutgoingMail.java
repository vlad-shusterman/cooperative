package by.bsuir.notification.entity;

import by.bsuir.notification.entity.enums.SendingType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Document(collection = "outgoing_mail")
public class OutgoingMail {

    @Id
    @MongoId(FieldType.OBJECT_ID)
    private String id;

    @Field
    private LocalDate sendingDate;

    @Field
//    @Indexed(unique = true)
    @NotNull
    private String index;

    @Field
    private String topic;

    @Field
    private String text;

    @Field
    @NotNull
    private SendingType sendingType;

    @Field
    @NotNull
    private String receiver;
}
