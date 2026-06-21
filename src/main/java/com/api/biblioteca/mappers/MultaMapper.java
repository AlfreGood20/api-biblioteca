package com.api.biblioteca.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.api.biblioteca.dtos.response.MultaResponse;
import com.api.biblioteca.models.Multa;

@Mapper(componentModel = "spring")
public interface MultaMapper {

    // Entity to dto
    @Mapping(source = "estado.nombre", target = "estado")
    MultaResponse entityToDto(Multa entity);

    List<MultaResponse> listEntityToListDto(List<Multa> list);
}