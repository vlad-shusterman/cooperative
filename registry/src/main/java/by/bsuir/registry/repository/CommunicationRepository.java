package by.bsuir.registry.repository;

import by.bsuir.registry.model.Communication;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CommunicationRepository extends MongoRepository<Communication, String> {

    Collection<Communication> findByPersonIdIn(Collection<String> personId);

}
