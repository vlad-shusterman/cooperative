package by.bsuir.document.service.tag;

import by.bsuir.document.model.template.Tag;

import java.util.List;

/**
 * Service manager to working with system {@link Tag}s.
 *
 * @author Vladislav Novitskiy
 */
public interface TagManager {
    /**
     * Method find all system tags.
     *
     * @return All system tags
     */
    List<Tag> findAll();
}
