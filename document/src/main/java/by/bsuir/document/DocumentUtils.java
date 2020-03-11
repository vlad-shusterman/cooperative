package by.bsuir.document;

import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DocumentUtils {
    @Value("${templates.path}")
    private static String templatesPath;

    @Value("${documents.path}")
    private static String documentsPath;

    public static void createDirs(String path) throws IOException {
        Files.createDirectories(Paths.get(path).getParent());
    }

    public static String getDocumentsPath(String path) {
        return documentsPath + "/" + path;
    }

    public static String getTemplate(String templateName) {
        return templatesPath + "/" + templateName;
    }
}
