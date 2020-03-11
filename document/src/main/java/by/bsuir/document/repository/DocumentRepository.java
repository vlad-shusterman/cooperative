package by.bsuir.document.repository;

import by.bsuir.document.model.document.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for {@link Document} entities.
 *
 * @author Vladislav Novitskiy
 */
@Repository
public interface DocumentRepository extends MongoRepository<Document, String> {
}
