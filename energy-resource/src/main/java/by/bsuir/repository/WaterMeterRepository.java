package by.bsuir.repository;

import by.bsuir.model.entity.meter.WaterMeter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterMeterRepository extends MongoRepository<WaterMeter, String> {

    Page<WaterMeter> findAllByPersonId(String id, Pageable pageable);
}



