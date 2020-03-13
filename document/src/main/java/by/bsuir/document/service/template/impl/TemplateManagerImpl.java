package by.bsuir.document.service.template.impl;

import by.bsuir.core.exceptions.DataManipulateException;
import by.bsuir.core.service.impl.CrudManagerImpl;
import by.bsuir.document.model.template.Template;
import by.bsuir.document.repository.TemplateRepository;
import by.bsuir.document.service.template.TemplateManager;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Default implementation of {@link TemplateManager}.
 *
 * @author Vladislav Novitskiy
 */
@ParametersAreNonnullByDefault
@Service
public class TemplateManagerImpl extends CrudManagerImpl<TemplateRepository, Template> implements TemplateManager {
    public TemplateManagerImpl(TemplateRepository mongoRepository) {
        super(mongoRepository);
    }

    @Override
    public Template update(Template template) throws DataManipulateException {
        if (mongoRepository.findById(template.getId()).isPresent()) {
            return mongoRepository.save(template);
        }
        throw new DataManipulateException();
    }

    @Override
    public Template findByName(String name) {
        Template template = new Template();
        template.setName(name);
        return mongoRepository.findOne(Example.of(template)).orElseThrow(DataManipulateException::new);
    }
}
