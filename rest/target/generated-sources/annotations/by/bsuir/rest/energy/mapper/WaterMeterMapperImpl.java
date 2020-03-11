package by.bsuir.rest.energy.mapper;

import by.bsuir.model.entity.meter.WaterMeter;
import by.bsuir.model.entity.meter.WaterMeterType;
import by.bsuir.rest.energy.model.WaterMeterDto;
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
public class WaterMeterMapperImpl implements WaterMeterMapper {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public WaterMeter fromDto(WaterMeterDto dto) {
        if ( dto == null ) {
            return null;
        }

        WaterMeter waterMeter = new WaterMeter();

        waterMeter.setId( dto.getId() );
        waterMeter.setNumber( dto.getNumber() );
        waterMeter.setValue( dto.getValue() );
        waterMeter.setReadingDate( dto.getReadingDate() );
        if ( dto.getType() != null ) {
            waterMeter.setType( Enum.valueOf( WaterMeterType.class, dto.getType() ) );
        }
        waterMeter.setPerson( personMapper.fromDto( dto.getPerson() ) );

        return waterMeter;
    }

    @Override
    public WaterMeterDto toDto(WaterMeter entity) {
        if ( entity == null ) {
            return null;
        }

        WaterMeterDto waterMeterDto = new WaterMeterDto();

        waterMeterDto.setId( entity.getId() );
        waterMeterDto.setValue( entity.getValue() );
        waterMeterDto.setNumber( entity.getNumber() );
        waterMeterDto.setReadingDate( entity.getReadingDate() );
        if ( entity.getType() != null ) {
            waterMeterDto.setType( entity.getType().name() );
        }
        waterMeterDto.setPerson( personMapper.toDtoCompact( entity.getPerson() ) );

        return waterMeterDto;
    }
}
