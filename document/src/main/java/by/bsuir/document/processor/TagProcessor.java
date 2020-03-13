package by.bsuir.document.processor;

import by.bsuir.document.model.template.Tag;

import java.util.Map;

/**
 * Processing tags.
 *
 * @author Vladislav Novitskiy
 */
public interface TagProcessor {
    /**
     * Method process tags with parameter values.
     *
     * @param paramValues Values for processing
     * @return Processed entity for document
     */
    Object process(Map<Tag.Param, String> paramValues);
}
