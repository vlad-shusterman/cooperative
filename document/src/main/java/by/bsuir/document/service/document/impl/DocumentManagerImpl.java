package by.bsuir.document.service.document.impl;

import by.bsuir.core.service.impl.CrudManagerImpl;
import by.bsuir.document.model.document.Document;
import by.bsuir.document.repository.DocumentRepository;
import by.bsuir.document.service.document.DocumentManager;
import org.springframework.stereotype.Service;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Default implementation of {@link DocumentManager}.
 *
 * @author Vladislav Novitskiy
 */
@ParametersAreNonnullByDefault
@Service
public class DocumentManagerImpl extends CrudManagerImpl<DocumentRepository, Document> implements DocumentManager {
    public DocumentManagerImpl(DocumentRepository mongoRepository) {
        super(mongoRepository);
    }
}
