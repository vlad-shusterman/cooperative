package by.bsuir.document.generator;

import java.util.Map;

/**
 * Document generation service.
 *
 * @author Vladislav Novitskiy
 */
public interface DocumentGenerator {
    /**
     * Method generate document of configured template with filed values of tags.
     *  @param templatePath Path to template document
     * @param outputPath   Output file name where generated document will save
     * @param tagValues    Values which will replace document tags
     */
    void generateDocument(String templatePath, String outputPath, Map<String, Object> tagValues);
}
