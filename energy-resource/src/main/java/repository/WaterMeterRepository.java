package repository;

import model.entity.meter.WaterMeter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterMeterRepository extends MongoRepository<WaterMeter, Long> {

}



