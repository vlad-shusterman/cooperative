package by.bsuir.rest.document.model;

import by.bsuir.document.model.template.Tag;
import by.bsuir.rest.registry.IDValidationGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.util.List;

/**
 * @author Vladislav Novitskiy
 */
@Data
public class TemplateEntity {
    @Null
    @NotBlank(groups = IDValidationGroup.class)
    private String id;

    @NotBlank
    private String name;

    private List<Tag> tags;

    private List<CompositeTagEntity> compositeTags;

    @NotBlank
    private String path;
}
