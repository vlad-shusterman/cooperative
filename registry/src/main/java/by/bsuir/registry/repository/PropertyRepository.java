package by.bsuir.registry.repository;

import by.bsuir.registry.model.Property;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PropertyRepository extends MongoRepository<Property, String> {

    @Query("{'owners': { '$exists': true, '$not': {$size: 0}}}")
    Collection<Property> findAllWithOwners();

}
