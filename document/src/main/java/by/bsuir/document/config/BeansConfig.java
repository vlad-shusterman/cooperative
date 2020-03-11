package by.bsuir.document.config;

import by.bsuir.document.model.template.Tag;
import by.bsuir.document.processor.TagProcessor;
import by.bsuir.document.processor.impl.ATPProcessor;
import by.bsuir.document.processor.impl.FamilyProcessor;
import by.bsuir.document.processor.impl.PASPProcessor;
import by.bsuir.document.processor.impl.PNProcessor;
import by.bsuir.document.service.tag.DelayFormatService;
import by.bsuir.registry.service.PersonManager;
import com.ibm.icu.text.RuleBasedNumberFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;
import java.util.EnumMap;
import java.util.Locale;
import java.util.Map;

import static by.bsuir.document.model.template.Tag.*;

/**
 * @author Vladislav Novitskiy
 */
@Configuration
public class BeansConfig {
    @Bean
    public RuleBasedNumberFormat textNumberFormatter() {
        return new RuleBasedNumberFormat(Locale.forLanguageTag("ru"), RuleBasedNumberFormat.SPELLOUT);
    }

    @Bean
    public DateTimeFormatter dateTimeFormatter() {
        return DateTimeFormatter.ofPattern("dd.mm.yyyy");
    }

    @Autowired
    private DelayFormatService delayFormatService;
    @Autowired
    private PersonManager personManager;

    @Bean
    public Map<Tag, TagProcessor> tagProcessors() {
        Map<Tag, TagProcessor> processors = new EnumMap<>(Tag.class);
        processors.put(ATP, new ATPProcessor(delayFormatService));
        processors.put(PN, new PNProcessor(personManager));
        processors.put(FAMILY, new FamilyProcessor(personManager));
        processors.put(PASP, new PASPProcessor(personManager));
        return processors;
    }
}
