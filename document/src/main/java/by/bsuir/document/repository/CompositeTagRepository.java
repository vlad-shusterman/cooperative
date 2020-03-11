package by.bsuir.document.repository;

import by.bsuir.document.model.template.CompositeTag;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for {@link CompositeTag} entities.
 *
 * @author Vladislav Novitskiy
 */
@Repository
public interface CompositeTagRepository extends MongoRepository<CompositeTag, String> {
}
