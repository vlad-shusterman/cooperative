package by.bsuir.rest.notification.model;

import by.bsuir.notification.entity.enums.Assignee;
import by.bsuir.notification.entity.enums.ControlType;
import by.bsuir.notification.entity.enums.SendingType;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class IncomingMailDto {

    private String id;

    private LocalDate receivingDate;

    @NotNull
    private String addresser;

    @NotNull
    private String index;

    private String topic;

    private String text;

    @NotNull
    private LocalDate registrationDate;

    @NotNull
    private SendingType sendingType;

    private ControlType controlType;

    private Assignee assignee;
}
