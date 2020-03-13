package by.bsuir.document.service.tag.impl;

import by.bsuir.core.service.impl.CrudManagerImpl;
import by.bsuir.document.model.template.CompositeTag;
import by.bsuir.document.repository.CompositeTagRepository;
import by.bsuir.document.service.tag.CompositeTagManager;
import org.springframework.stereotype.Service;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * @author Vladislav Novitskiy
 */
@ParametersAreNonnullByDefault
@Service
public class CompositeTagManagerImpl extends CrudManagerImpl<CompositeTagRepository, CompositeTag>
        implements CompositeTagManager {
    public CompositeTagManagerImpl(CompositeTagRepository mongoRepository) {
        super(mongoRepository);
    }
}
