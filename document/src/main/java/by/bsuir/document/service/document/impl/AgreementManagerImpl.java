package by.bsuir.document.service.document.impl;

import by.bsuir.core.service.impl.CrudManagerImpl;
import by.bsuir.document.model.document.Agreement;
import by.bsuir.document.repository.AgreementRepository;
import by.bsuir.document.service.document.AgreementManager;
import org.springframework.stereotype.Service;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Default implementation of {@link AgreementManager}.
 *
 * @author Vladislav Novitskiy
 */
@ParametersAreNonnullByDefault
@Service
public class AgreementManagerImpl extends CrudManagerImpl<AgreementRepository, Agreement> implements AgreementManager {
    public AgreementManagerImpl(AgreementRepository mongoRepository) {
        super(mongoRepository);
    }
}
