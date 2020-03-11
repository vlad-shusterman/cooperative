package by.bsuir.document.service.tag.impl;

import by.bsuir.document.model.template.Tag;
import by.bsuir.document.service.tag.TagManager;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Default implementation {@link TagManager}.
 *
 * @author Vladislav Novitskiy
 */
@Service
public class TagManagerImpl implements TagManager {

    @Override
    public List<Tag> findAll() {
        return Arrays.asList(Tag.values());
    }
}
