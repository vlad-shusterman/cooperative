package by.bsuir.export.template;

import by.bsuir.export.exporter.FileBasedTemplate;
import by.bsuir.model.entity.ElectricInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Component
public class ElectricTemplate extends FileBasedTemplate<ElectricInfo> {

    @Value("${export.template.electric-info-template}")
    private Resource template;

    @Override
    public String getFileName() {
        return String.format("Electric info on %s%s",
                LocalDate.now(),
                FileBasedTemplate.EXCEL_EXTENSION);
    }

    @Override
    public Resource getTemplate() {
        return template;
    }

    @Override
    public Map<String, Object> prepareData(List<ElectricInfo> entities) {
        return Map.of("electricInfos", entities,
                "currentDate", DateTimeFormatter.ofPattern("dd.MM.yyyy").format(LocalDateTime.now()));
    }
}
