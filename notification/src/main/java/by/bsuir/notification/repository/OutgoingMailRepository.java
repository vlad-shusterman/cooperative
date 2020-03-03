package by.bsuir.notification.repository;

import by.bsuir.notification.entity.OutgoingMail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutgoingMailRepository extends MongoRepository<OutgoingMail, String> {
}
