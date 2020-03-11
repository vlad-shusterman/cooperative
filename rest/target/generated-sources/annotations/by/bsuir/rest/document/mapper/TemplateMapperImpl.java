package by.bsuir.rest.document.mapper;

import by.bsuir.document.model.template.CompositeTag;
import by.bsuir.document.model.template.Tag;
import by.bsuir.document.model.template.Template;
import by.bsuir.rest.document.model.CompositeTagEntity;
import by.bsuir.rest.document.model.TemplateEntity;
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
public class TemplateMapperImpl implements TemplateMapper {

    @Override
    public TemplateEntity toDto(Template entity) {
        if ( entity == null ) {
            return null;
        }

        TemplateEntity templateEntity = new TemplateEntity();

        templateEntity.setId( entity.getId() );
        templateEntity.setName( entity.getName() );
        List<Tag> list = entity.getTags();
        if ( list != null ) {
            templateEntity.setTags( new ArrayList<Tag>( list ) );
        }
        templateEntity.setCompositeTags( compositeTagListToCompositeTagEntityList( entity.getCompositeTags() ) );
        templateEntity.setPath( entity.getPath() );

        return templateEntity;
    }

    @Override
    public Template fromDto(TemplateEntity dto) {
        if ( dto == null ) {
            return null;
        }

        Template template = new Template();

        template.setId( dto.getId() );
        template.setName( dto.getName() );
        List<Tag> list = dto.getTags();
        if ( list != null ) {
            template.setTags( new ArrayList<Tag>( list ) );
        }
        template.setCompositeTags( compositeTagEntityListToCompositeTagList( dto.getCompositeTags() ) );
        template.setPath( dto.getPath() );

        return template;
    }

    protected CompositeTagEntity compositeTagToCompositeTagEntity(CompositeTag compositeTag) {
        if ( compositeTag == null ) {
            return null;
        }

        CompositeTagEntity compositeTagEntity = new CompositeTagEntity();

        compositeTagEntity.setId( compositeTag.getId() );
        compositeTagEntity.setName( compositeTag.getName() );
        List<Tag> list = compositeTag.getTags();
        if ( list != null ) {
            compositeTagEntity.setTags( new ArrayList<Tag>( list ) );
        }

        return compositeTagEntity;
    }

    protected List<CompositeTagEntity> compositeTagListToCompositeTagEntityList(List<CompositeTag> list) {
        if ( list == null ) {
            return null;
        }

        List<CompositeTagEntity> list1 = new ArrayList<CompositeTagEntity>( list.size() );
        for ( CompositeTag compositeTag : list ) {
            list1.add( compositeTagToCompositeTagEntity( compositeTag ) );
        }

        return list1;
    }

    protected CompositeTag compositeTagEntityToCompositeTag(CompositeTagEntity compositeTagEntity) {
        if ( compositeTagEntity == null ) {
            return null;
        }

        CompositeTag compositeTag = new CompositeTag();

        compositeTag.setId( compositeTagEntity.getId() );
        compositeTag.setName( compositeTagEntity.getName() );
        List<Tag> list = compositeTagEntity.getTags();
        if ( list != null ) {
            compositeTag.setTags( new ArrayList<Tag>( list ) );
        }

        return compositeTag;
    }

    protected List<CompositeTag> compositeTagEntityListToCompositeTagList(List<CompositeTagEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<CompositeTag> list1 = new ArrayList<CompositeTag>( list.size() );
        for ( CompositeTagEntity compositeTagEntity : list ) {
            list1.add( compositeTagEntityToCompositeTag( compositeTagEntity ) );
        }

        return list1;
    }
}
