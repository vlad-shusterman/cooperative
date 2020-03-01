package by.bsuir.document;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DocumentUtils {
    private static final String TEMPLATES_PATH = "data/templates";
    private static final String DOCUMENTS_PATH = "data/documents";

    public static void createDirs(String path) throws IOException {
        Files.createDirectories(Paths.get(path).getParent());
    }

    public static String getDocumentsPath(String path) {
        return DOCUMENTS_PATH + "/" + path;
    }

    public static String getTemplate(String templateName) {
        return TEMPLATES_PATH + "/" + templateName;
    }
}
