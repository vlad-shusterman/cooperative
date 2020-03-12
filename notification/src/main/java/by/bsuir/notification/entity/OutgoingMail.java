package by.bsuir.notification.entity;

import by.bsuir.notification.entity.enums.SendingType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "outgoing_mail")
public class OutgoingMail extends Mail {

    @Id
    @MongoId(FieldType.OBJECT_ID)
    private String id;

    @Field
    private Date sendingDate;

    @Field
    @NotNull
    private String index;

//    @Field
//    private String subject;
//
//    @Field
//    private String text;

    @Field
    @NotNull
    private SendingType sendingType;

//    @Field
//    @NotNull
//    private String receiver;
}
