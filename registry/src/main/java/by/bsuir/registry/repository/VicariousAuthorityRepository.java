package by.bsuir.registry.repository;

import by.bsuir.registry.model.VicariousAuthority;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface VicariousAuthorityRepository extends MongoRepository<VicariousAuthority, String> {

    Collection<VicariousAuthority> findByPersonIdIn(Collection<String> personId);

    Collection<VicariousAuthority> findByProprietorIdIn(Collection<String> personId);

}
