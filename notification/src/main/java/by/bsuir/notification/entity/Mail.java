package by.bsuir.notification.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.util.List;

@Data
public class Mail {

    @NotNull
    @Field
    List<String> receivers;

    @NotNull
    @Field
    String subject;

    @NotNull
    @Field
    String text;

    boolean html;

    List<File> attachments;
}
