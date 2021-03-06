package by.bsuir.rest.registry.model;

import by.bsuir.rest.registry.IDValidationGroup;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

@Data
public class VicariousAuthorityEntity {

    @NotBlank(groups = IDValidationGroup.class)
    @Null
    private String id;
    @ApiModelProperty(required = true, value = "Person which issued vicarious authority.")
    @NotBlank// From
    private String proprietorId;
    @NotBlank // TimeUnit seconds since 1970....
    private long startDate;
    @NotBlank // TimeUnit days
    private long duration;
    @NotBlank // To
    private String personId;
}
