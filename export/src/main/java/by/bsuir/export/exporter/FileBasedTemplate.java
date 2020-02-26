package by.bsuir.export.exporter;

import by.bsuir.model.common.Exportable;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

public abstract class FileBasedTemplate<T extends Exportable> {

    public static final String EXCEL_EXTENSION = ".xlsx";

    public abstract String getFileName(T entity);

    public abstract Resource getTemplate();

    public abstract Map<String, Object> prepareData(T entity);

    public ByteArrayResource createExcel(T entity) {
        try (var inputStream = getTemplate().getInputStream()) {
            try (var outputStream = new ByteArrayOutputStream()) {
                var context = createContext(entity);
                JxlsHelper.getInstance().processTemplate(inputStream, outputStream, context);
                return new ByteArrayResource(outputStream.toByteArray());
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private Context createContext(T entity) {
        var context = new Context();
        prepareData(entity).forEach(context::putVar);
        return context;
    }
}
