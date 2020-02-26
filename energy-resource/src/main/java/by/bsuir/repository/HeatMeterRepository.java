package by.bsuir.repository;

import by.bsuir.model.entity.meter.HeatMeter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeatMeterRepository extends MongoRepository<HeatMeter, String> {

    Page<HeatMeter> findAllByPersonId(String id, Pageable pageable);
}



