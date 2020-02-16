package by.bsuir.rest.mapper;

public interface EntityMapper<D, E> {

    D toDto(E entity);

    E fromDto(D dto);

}
