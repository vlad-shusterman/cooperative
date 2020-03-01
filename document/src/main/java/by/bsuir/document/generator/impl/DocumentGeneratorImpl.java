package by.bsuir.document.generator.impl;

import by.bsuir.document.DocumentUtils;
import by.bsuir.document.exception.DocumentGenerationException;
import by.bsuir.document.generator.DocumentGenerator;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Map;

/**
 * {@link DocumentGenerator} implementation.
 *
 * @author Vladislav Novitskiy
 */
@Component
public class DocumentGeneratorImpl implements DocumentGenerator {
    private static final Logger LOGGER = LoggerFactory.getLogger(DocumentGeneratorImpl.class);

    @Override
    public void generateDocument(String templatePath, Map<String, Object> tagValues, String outputPath) {
        try {
            String fullPath = DocumentUtils.getDocumentsPath(outputPath);
            DocumentUtils.createDirs(fullPath);
            LOGGER.info("File '{}' created", outputPath);

            // Load Docx file by filling Velocity template engine and cache it to the registry
            InputStream in = new FileInputStream(new File(DocumentUtils.getTemplate(templatePath)));
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);

            // Create context Java model
            IContext context = report.createContext(tagValues);

            // Generate report by merging Java model with the Docx
            OutputStream out = new FileOutputStream(fullPath);
            report.process(context, out);
            LOGGER.info("File '{}' successfully saved", outputPath);
        } catch (XDocReportException | IOException e) {
            throw new DocumentGenerationException(e);
        }
    }
}
