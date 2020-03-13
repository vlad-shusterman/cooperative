package by.bsuir.document.config;

import by.bsuir.document.model.template.Tag;
import by.bsuir.document.processor.TagProcessor;
import by.bsuir.document.processor.impl.*;
import by.bsuir.document.processor.impl.communication.MailProcessor;
import by.bsuir.document.processor.impl.communication.PhoneProcessor;
import by.bsuir.document.service.tag.DelayFormatService;
import by.bsuir.registry.service.CommunicationManager;
import by.bsuir.registry.service.PersonManager;
import by.bsuir.registry.service.PropertyManager;
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
    @Autowired
    private PropertyManager propertyManager;
    @Autowired
    private CommunicationManager communicationManager;

    @Bean
    public Map<Tag, TagProcessor> tagProcessors() {
        Map<Tag, TagProcessor> processors = new EnumMap<>(Tag.class);
        processors.put(ATP, new AtpProcessor(delayFormatService));
        processors.put(PN, new PnProcessor(personManager));
        processors.put(FAMILY, new FamilyProcessor(personManager));
        processors.put(PASP, new PaspProcessor(personManager));
        processors.put(BOX_SQ, new BoxSqProcessor(propertyManager));
        processors.put(FIO, new FioProcessor());
        processors.put(INV, new InvProcessor(propertyManager));
        processors.put(MAIL, new MailProcessor(communicationManager));
        processors.put(PD, new PdProcessor(personManager, dateTimeFormatter()));
        processors.put(PHONE, new PhoneProcessor(communicationManager));
        processors.put(PW, new PwProcessor(personManager));
        return processors;
    }
}
