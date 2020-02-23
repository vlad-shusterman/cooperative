package repository;

import model.entity.meter.HeatMeter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeatMeterRepository extends MongoRepository<HeatMeter, Long> {

}



