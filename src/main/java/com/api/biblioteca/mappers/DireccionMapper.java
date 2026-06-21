package com.api.biblioteca.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.api.biblioteca.dtos.request.DireccionRequest;
import com.api.biblioteca.dtos.response.DireccionResponse;
import com.api.biblioteca.models.Direccion;

@Mapper(componentModel = "spring")
public interface DireccionMapper {

    // Entity -> dto
    @Mapping(source = "municipio.nombre", target = "municipio")
    DireccionResponse entityToDto(Direccion entity);

    // Dto -> Entity
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    @Mapping(target = "municipio", ignore = true)
    Direccion dtoToEntity(DireccionRequest request);
}