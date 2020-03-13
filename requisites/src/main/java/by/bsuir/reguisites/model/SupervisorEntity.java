package by.bsuir.reguisites.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Getter
@Setter
@Document(collection = "supervisor")
public class SupervisorEntity {

    @Id
    @MongoId(FieldType.OBJECT_ID)
    private String id;

    @Field
    private String surname;

    @Field
    private String name;

    @Field
    private String patronymic;

    @Field
    private Date startDate;

    @Field
    private Date endDate;

    @Field
    private String protocolNumber;

    @Field
    private String protocolScan;

    @Field
    private String signatureScan;
}
