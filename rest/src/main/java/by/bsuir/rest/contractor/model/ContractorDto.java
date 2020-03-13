package by.bsuir.rest.contractor.model;

import by.bsuir.rest.registry.model.PersonEntity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class ContractorDto {
    private String id;
    @NotNull
    private String type;
    @NotNull
    private String fullName;
    @NotNull
    private String juridicalAccount;
    @NotNull
    private String paymentAccount;
    @NotNull
    private String postAddress;
    @NotNull
    private String headName;
    @NotNull
    private String headPost;
    @NotNull
    private LocalDate registrationDate;
    private String description;
}
