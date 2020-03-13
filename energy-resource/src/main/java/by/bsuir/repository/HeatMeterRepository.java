package by.bsuir.repository;

import by.bsuir.model.entity.meter.ElectricMeter;
import by.bsuir.model.entity.meter.HeatMeter;
import by.bsuir.registry.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeatMeterRepository extends MongoRepository<HeatMeter, String> {

    Page<HeatMeter> findAllByPersonId(String id, Pageable pageable);

    Optional<HeatMeter> findByPerson(Person person);
}



