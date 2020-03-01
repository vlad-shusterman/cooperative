package by.bsuir.document.service.document.impl;

import by.bsuir.document.TemplateType;
import by.bsuir.document.generator.DocumentGenerator;
import by.bsuir.document.service.document.DocumentService;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Implementation of {@link DocumentService}.
 *
 * @author Vladislav Novitskiy
 */
@AllArgsConstructor
@Service
public class DocumentServiceImpl implements DocumentService {
    private Environment env;
    private DocumentGenerator generator;

    @Override
    public void generate(TemplateType templateType, Map<String, Object> tagValues, String outputPath) {
        String templatePath = env.getProperty(templateType.getPathProperty());
        generator.generateDocument(templatePath, tagValues, outputPath);
    }
}
