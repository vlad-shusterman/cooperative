package by.bsuir.document.processor.impl.communication;

import by.bsuir.document.model.template.Tag;
import by.bsuir.document.processor.TagProcessor;
import by.bsuir.registry.service.CommunicationManager;

import java.util.Map;

import static by.bsuir.registry.model.CommunicationTypes.MAIL;

/**
 * {@link TagProcessor} of {@link Tag#MAIL}.
 *
 * @author Vladislav Novitskiy
 */
public class MailProcessor extends CommunicationProcessor {
    public MailProcessor(CommunicationManager communicationManager) {
        super(communicationManager);
    }

    @Override
    public Object process(Map<Tag.Param, String> paramValues) {
        return processByCommunicationType(paramValues, MAIL);
    }
}
