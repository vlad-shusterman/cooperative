package by.bsuir.rest.document.dto;

import by.bsuir.rest.registry.IDValidationGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Vladislav Novitskiy
 */
@Data
public class AgreementData {
    @NotBlank(groups = IDValidationGroup.class)
    private String ownerId;

    @NotBlank(groups = IDValidationGroup.class)
    private String propertyId;
}
