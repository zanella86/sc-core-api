package com.sportconnection.sccoreapi.mapper;

public interface Mapper<D, E> {
    E convertToEntity(D dto);
    D convertToDTO(E entity);
}
