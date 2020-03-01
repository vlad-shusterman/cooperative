package by.bsuir.document;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Vladislav Novitskiy
 */
@AllArgsConstructor
@Getter
public enum TemplateType {
    AGREEMENT("agreement"),
    VICARIOUS_AUTHORITY("vicarious.authority"),
    DEFECTIVE_ACT("defective.act"),
    EQUIPMENT_TRANSFER_ACT("equipment.transfer.act"),
    REGISTRATION_SHEET("registration.sheet");

    private String pathProperty;
}
