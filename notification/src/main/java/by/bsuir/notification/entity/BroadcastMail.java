package by.bsuir.notification.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Document(collection = "broadcast_mail")
public class BroadcastMail {

    @Id
    @MongoId(FieldType.OBJECT_ID)
    private String id;

    @Field
//    @NotNull
    private LocalDate sendingDate;

    @Field
    private String index;

    @Field
    private String topic;

    @Field
    private String text;

    @Field
    @NotNull
    private String receiver;
}
