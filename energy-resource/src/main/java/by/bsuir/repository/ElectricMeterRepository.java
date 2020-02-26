package by.bsuir.repository;

import by.bsuir.model.entity.meter.ElectricMeter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectricMeterRepository extends MongoRepository<ElectricMeter, String> {

    Page<ElectricMeter> findAllByPersonId(String id, Pageable pageable);
}



