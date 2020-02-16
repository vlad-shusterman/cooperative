package by.bsuir.rest.registry.mapper;

import by.bsuir.registry.model.VicariousAuthority;
import by.bsuir.rest.mapper.EntityMapper;
import by.bsuir.rest.registry.model.VicariousAuthorityEntity;
import org.springframework.stereotype.Service;

@Service
public class VicariousAuthorityEntityMapper implements EntityMapper<VicariousAuthorityEntity, VicariousAuthority> {

    @Override
    public VicariousAuthorityEntity toDto(VicariousAuthority entity) {
        return new VicariousAuthorityEntity(
                entity.getId(),
                entity.getProprietorId(),
                entity.getStartDate(),
                entity.getDuration(),
                entity.getPersonId()
        );
    }

    @Override
    public VicariousAuthority fromDto(VicariousAuthorityEntity dto) {
        return new VicariousAuthority(
                dto.getId(),
                dto.getProprietorId(),
                dto.getStartDate(),
                dto.getDuration(),
                dto.getPersonId()
        );
    }

}
