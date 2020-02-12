package by.bsuir.core.repository;

import by.bsuir.core.entity.Test;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestRepository extends MongoRepository<Test, Long> {
}
