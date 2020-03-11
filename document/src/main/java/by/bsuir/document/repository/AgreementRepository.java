package by.bsuir.document.repository;

import by.bsuir.document.model.document.Agreement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for {@link Agreement} entities.
 *
 * @author Vladislav Novitskiy
 */
@Repository
public interface AgreementRepository extends MongoRepository<Agreement, String> {
}
