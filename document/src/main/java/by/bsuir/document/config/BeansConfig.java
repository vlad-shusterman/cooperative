package by.bsuir.document.config;

import com.ibm.icu.text.RuleBasedNumberFormat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

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
}
