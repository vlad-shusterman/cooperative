package by.bsuir.rest.notification.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class BroadcastMailDto {

    private String id;

    private LocalDate sendingDate;

    private String index;

    private String topic;

    private String text;

    @NotNull
    private String receiver;
}
