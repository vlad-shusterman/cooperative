package by.bsuir.document.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Vladislav Novitskiy
 */
@Configuration
@PropertySource("file:settings/paths.properties")
public class PropertiesWithJavaConfig {
}
