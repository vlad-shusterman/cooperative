package by.bsuir.repository;

import by.bsuir.model.entity.HeatInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeatInfoRepository extends MongoRepository<HeatInfo, String> {
}
