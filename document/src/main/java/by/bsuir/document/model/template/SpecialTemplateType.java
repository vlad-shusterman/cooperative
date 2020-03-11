package by.bsuir.document.model.template;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Vladislav Novitskiy
 */
@AllArgsConstructor
@Getter
public enum SpecialTemplateType {
    AGREEMENT("agreement"),
    VICARIOUS_AUTHORITY("vicarious_authority");

    private String id;
}
