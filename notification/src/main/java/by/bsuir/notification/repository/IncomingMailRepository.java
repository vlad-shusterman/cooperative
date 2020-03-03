package by.bsuir.notification.repository;

import by.bsuir.notification.entity.IncomingMail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomingMailRepository extends MongoRepository<IncomingMail, String> {
}
