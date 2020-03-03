package by.bsuir.rest.notification.model;

import by.bsuir.notification.entity.enums.SendingType;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class OutgoingMailDto {

    private String id;

    private LocalDate sendingDate;

    @NotNull
    private String index;

    private String topic;

    private String text;

    @NotNull
    private SendingType sendingType;

    @NotNull
    private String receiver;
}
