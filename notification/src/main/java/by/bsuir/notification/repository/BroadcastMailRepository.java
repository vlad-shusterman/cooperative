package by.bsuir.notification.repository;

import by.bsuir.notification.entity.BroadcastMail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BroadcastMailRepository extends MongoRepository<BroadcastMail, String> {
}
