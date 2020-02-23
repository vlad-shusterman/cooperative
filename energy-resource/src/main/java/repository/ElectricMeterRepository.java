package repository;

import model.entity.meter.ElectricMeter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectricMeterRepository extends MongoRepository<ElectricMeter, Long> {

}



