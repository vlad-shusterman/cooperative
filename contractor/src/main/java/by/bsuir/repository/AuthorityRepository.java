package by.bsuir.repository;

import by.bsuir.model.entity.contractor.Authority;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends MongoRepository<Authority,String> {

}
