package by.bsuir.rest.energy.mapper;

import by.bsuir.model.entity.meter.ElectricMeter;
import by.bsuir.rest.energy.model.ElectricMeterDto;
import by.bsuir.rest.registry.mapper.PersonMapper;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-03-10T22:50:10+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class ElectricMeterMapperImpl implements ElectricMeterMapper {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public ElectricMeter fromDto(ElectricMeterDto dto) {
        if ( dto == null ) {
            return null;
        }

        ElectricMeter electricMeter = new ElectricMeter();

        electricMeter.setId( dto.getId() );
        electricMeter.setNumber( dto.getNumber() );
        electricMeter.setValue( dto.getValue() );
        electricMeter.setReadingDate( dto.getReadingDate() );
        electricMeter.setTransformationRatio( dto.getTransformationRatio() );
        electricMeter.setPerson( personMapper.fromDto( dto.getPerson() ) );

        return electricMeter;
    }

    @Override
    public ElectricMeterDto toDto(ElectricMeter entity) {
        if ( entity == null ) {
            return null;
        }

        ElectricMeterDto electricMeterDto = new ElectricMeterDto();

        electricMeterDto.setId( entity.getId() );
        electricMeterDto.setValue( entity.getValue() );
        electricMeterDto.setNumber( entity.getNumber() );
        electricMeterDto.setReadingDate( entity.getReadingDate() );
        electricMeterDto.setTransformationRatio( entity.getTransformationRatio() );
        electricMeterDto.setPerson( personMapper.toDtoCompact( entity.getPerson() ) );

        return electricMeterDto;
    }
}
