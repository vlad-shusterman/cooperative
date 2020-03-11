package by.bsuir.rest.document.mapper;

import by.bsuir.document.model.template.CompositeTag;
import by.bsuir.document.model.template.Tag;
import by.bsuir.rest.document.model.CompositeTagEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-03-10T22:50:09+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class CompositeTagMapperImpl implements CompositeTagMapper {

    @Override
    public CompositeTagEntity toDto(CompositeTag entity) {
        if ( entity == null ) {
            return null;
        }

        CompositeTagEntity compositeTagEntity = new CompositeTagEntity();

        compositeTagEntity.setId( entity.getId() );
        compositeTagEntity.setName( entity.getName() );
        List<Tag> list = entity.getTags();
        if ( list != null ) {
            compositeTagEntity.setTags( new ArrayList<Tag>( list ) );
        }

        return compositeTagEntity;
    }

    @Override
    public CompositeTag fromDto(CompositeTagEntity dto) {
        if ( dto == null ) {
            return null;
        }

        CompositeTag compositeTag = new CompositeTag();

        compositeTag.setId( dto.getId() );
        compositeTag.setName( dto.getName() );
        List<Tag> list = dto.getTags();
        if ( list != null ) {
            compositeTag.setTags( new ArrayList<Tag>( list ) );
        }

        return compositeTag;
    }
}
