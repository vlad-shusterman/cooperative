package by.bsuir.notification.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.File;
import java.util.List;

@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Mail {
    List<String> to;
    String subject;
    String text;
    boolean html;
    List<File> attachments;
}
