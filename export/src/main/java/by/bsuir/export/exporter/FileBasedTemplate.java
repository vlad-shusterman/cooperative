package by.bsuir.export.exporter;

import by.bsuir.model.common.Exportable;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public abstract class FileBasedTemplate<T extends Exportable> {

    public static final String EXCEL_EXTENSION = ".xlsx";

    public abstract String getFileName();

    public abstract Resource getTemplate();

    public abstract Map<String, Object> prepareData(List<T> entities);

    public ByteArrayResource createExcel(List<T> entities) {
        try (var inputStream = getTemplate().getInputStream()) {
            try (var outputStream = new ByteArrayOutputStream()) {
                var context = createContext(entities);
                JxlsHelper.getInstance().processTemplate(inputStream, outputStream, context);
                return new ByteArrayResource(outputStream.toByteArray());
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private Context createContext(List<T> entities) {
        var context = new Context();
        prepareData(entities).forEach(context::putVar);
        return context;
    }
}
