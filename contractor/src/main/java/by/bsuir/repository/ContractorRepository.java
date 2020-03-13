package by.bsuir.repository;

import by.bsuir.model.entity.contractor.Contractor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractorRepository extends MongoRepository<Contractor,String> {

}
