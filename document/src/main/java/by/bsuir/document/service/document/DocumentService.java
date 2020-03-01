package by.bsuir.document.service.document;

import by.bsuir.document.TemplateType;

import java.util.Map;

/**
 * Document actions service.
 *
 * @author Vladislav Novitskiy
 */
public interface DocumentService {
    /**
     * Method generates document of specified type by tag values at specified directory.
     *
     * @param templateType Type of generated document
     * @param tagValues    Values of tags
     * @param outputPath   Output dir
     */
    void generate(TemplateType templateType, Map<String, Object> tagValues, String outputPath);
}
