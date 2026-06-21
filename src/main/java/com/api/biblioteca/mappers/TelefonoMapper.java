package com.api.biblioteca.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.api.biblioteca.dtos.request.TelefonoRequest;
import com.api.biblioteca.dtos.response.TelefonoResponse;
import com.api.biblioteca.models.Telefono;

@Mapper(componentModel = "spring")
public interface TelefonoMapper {

    // Entity To dto
    @Mapping(source = "tipo.nombre", target = "tipo")
    TelefonoResponse entityToDto(Telefono entity);

    // Dto To entity
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    @Mapping(target = "tipo", ignore = true)
    Telefono dtoToEntity(TelefonoRequest request);

    List<TelefonoResponse> listEntityToListDto(List<Telefono> list);
}
