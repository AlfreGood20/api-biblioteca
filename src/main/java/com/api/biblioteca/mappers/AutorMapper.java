package com.api.biblioteca.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.api.biblioteca.dtos.request.AutorRequest;
import com.api.biblioteca.dtos.response.AutorResponse;
import com.api.biblioteca.models.Autor;

@Mapper(componentModel = "spring")
public interface AutorMapper {

    // ENTIDAD -> DTO
    @Mapping(source = "nacionalidad.nombre", target = "nacionalidad")
    AutorResponse entityToDto(Autor entity);

    //DTO REQUEST -> ENTIDAD
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "libros", ignore = true)
    @Mapping(target = "nacionalidad", ignore = true)
    Autor dtoToEntity(AutorRequest request);

    List<AutorResponse> listEntityToListDto(List<Autor> list);
}
