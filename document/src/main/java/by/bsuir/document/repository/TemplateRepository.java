package by.bsuir.document.repository;

import by.bsuir.document.model.template.Template;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for {@link Template} entities.
 *
 * @author Vladislav Novitskiy
 */
@Repository
public interface TemplateRepository extends MongoRepository<Template, String> {
}
