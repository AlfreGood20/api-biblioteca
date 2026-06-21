package com.api.biblioteca.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.api.biblioteca.dtos.request.EjemplarRequest;
import com.api.biblioteca.dtos.response.EjemplarResponse;
import com.api.biblioteca.models.Ejemplar;

@Mapper(componentModel = "spring")
public interface EjemplarMapper {

    // Entity to dto
    @Mapping(source = "estado.nombre", target = "estado")
    EjemplarResponse entityToDto(Ejemplar entity);

    // dto -> entity
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "libro", ignore = true)
    @Mapping(target = "estado", ignore = true)
    Ejemplar dtoToEntity(EjemplarRequest request);

    List<EjemplarResponse> listEntityToListDto(List<Ejemplar> list);
}
