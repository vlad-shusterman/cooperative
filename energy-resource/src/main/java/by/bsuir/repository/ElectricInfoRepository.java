package by.bsuir.repository;

import by.bsuir.model.entity.ElectricInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectricInfoRepository extends MongoRepository<ElectricInfo, String> {
}
