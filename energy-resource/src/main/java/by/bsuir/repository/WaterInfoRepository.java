package by.bsuir.repository;

import by.bsuir.model.entity.WaterInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterInfoRepository extends MongoRepository<WaterInfo, String> {
}
