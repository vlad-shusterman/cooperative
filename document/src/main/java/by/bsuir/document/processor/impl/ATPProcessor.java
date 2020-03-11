package by.bsuir.document.processor.impl;

import by.bsuir.document.model.template.Tag;
import by.bsuir.document.processor.TagProcessor;
import by.bsuir.document.service.tag.DelayFormatService;
import lombok.AllArgsConstructor;

import java.util.Map;

import static by.bsuir.document.model.template.Tag.Param.DURATION;
import static by.bsuir.document.model.template.Tag.Param.START_DATE;

/**
 * Processor of {@link Tag#ATP}.
 *
 * @author Vladislav Novitskiy
 */
@AllArgsConstructor
public class ATPProcessor implements TagProcessor {
    private DelayFormatService delayFormatService;

    @Override
    public Object process(Map<Tag.Param, String> paramValues) {
        long startDate = Long.parseLong(paramValues.get(START_DATE));
        long duration = Long.parseLong(paramValues.get(DURATION));

        return delayFormatService.formatDelay(startDate, duration);
    }
}
