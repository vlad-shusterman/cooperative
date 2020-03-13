package by.bsuir.export.service;

import by.bsuir.export.exporter.FileBasedTemplate;
import by.bsuir.export.model.ExportResponse;
import by.bsuir.model.common.Exportable;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExportService<T extends Exportable> {

    private static final String EXCEL_MEDIA_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    public ExportResponse exportEntities(FileBasedTemplate<T> template, List<T> entities) {
        ByteArrayResource excelFile = template.createExcel(entities);
        return ExportResponse.builder()
                .stream(excelFile)
                .headers(createHeaders(excelFile, template.getFileName()))
                .build();
    }

    private HttpHeaders createHeaders(ByteArrayResource file, String fileName) {
        var header = new HttpHeaders();
        header.setContentLength(file.contentLength());
        header.setContentType(MediaType.parseMediaType(EXCEL_MEDIA_TYPE));
        header.set(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=\"%s\"", fileName));
        return header;
    }
}
