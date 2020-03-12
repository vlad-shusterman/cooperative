package by.bsuir.export.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;

@Data
@Builder
public class ExportResponse {

    private HttpHeaders headers;
    private ByteArrayResource stream;
}
