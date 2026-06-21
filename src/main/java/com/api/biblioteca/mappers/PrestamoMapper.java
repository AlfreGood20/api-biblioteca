package com.api.biblioteca.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.api.biblioteca.dtos.request.PrestamoRequest;
import com.api.biblioteca.dtos.response.PrestamoResponse;
import com.api.biblioteca.models.Prestamo;

@Mapper(componentModel = "spring", uses = {EjemplarMapper.class, UsuarioMapper.class})
public interface PrestamoMapper {

    // Entity to dto
    @Mapping(source = "estado.nombre", target = "estado")
    PrestamoResponse entityToDto(Prestamo entity);

    // DTO to entity
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fechaRegistro", ignore = true)
    @Mapping(target = "multa", ignore = true)
    @Mapping(target = "ejemplar", ignore = true)
    @Mapping(target = "fechaLimite", ignore = true)
    @Mapping(target = "fechaDevolucion", ignore = true)
    @Mapping(target = "estado", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    @Mapping(target = "usuarioAdmin", ignore = true)
    Prestamo dtoToEntity(PrestamoRequest request);

    List<PrestamoResponse> listEntityToListDto(List<Prestamo> list);
}
