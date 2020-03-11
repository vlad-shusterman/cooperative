package by.bsuir.rest.contractor.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class AuthorityDto {
    private String id;
    @NotNull
    private String fullName;
    @NotNull
    private String juridicalAccount;
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
