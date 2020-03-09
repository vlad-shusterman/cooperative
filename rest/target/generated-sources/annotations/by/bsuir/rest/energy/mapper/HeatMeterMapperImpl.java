package by.bsuir.rest.energy.mapper;

import by.bsuir.model.entity.meter.HeatMeter;
import by.bsuir.rest.energy.model.HeatMeterDto;
import by.bsuir.rest.registry.mapper.PersonMapper;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-03-09T21:23:15+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class HeatMeterMapperImpl implements HeatMeterMapper {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public HeatMeter fromDto(HeatMeterDto dto) {
        if ( dto == null ) {
            return null;
        }

        HeatMeter heatMeter = new HeatMeter();

        heatMeter.setId( dto.getId() );
        heatMeter.setNumber( dto.getNumber() );
        heatMeter.setValue( dto.getValue() );
        heatMeter.setReadingDate( dto.getReadingDate() );
        heatMeter.setPerson( personMapper.fromDto( dto.getPerson() ) );

        return heatMeter;
    }

    @Override
    public HeatMeterDto toDto(HeatMeter entity) {
        if ( entity == null ) {
            return null;
        }

        HeatMeterDto heatMeterDto = new HeatMeterDto();

        heatMeterDto.setId( entity.getId() );
        heatMeterDto.setValue( entity.getValue() );
        heatMeterDto.setNumber( entity.getNumber() );
        heatMeterDto.setReadingDate( entity.getReadingDate() );
        heatMeterDto.setPerson( personMapper.toDtoCompact( entity.getPerson() ) );

        return heatMeterDto;
    }
}
