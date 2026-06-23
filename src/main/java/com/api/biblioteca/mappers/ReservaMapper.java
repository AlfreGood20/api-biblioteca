package com.api.biblioteca.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.api.biblioteca.dtos.response.ReservaResponse;
import com.api.biblioteca.models.Reserva;

@Mapper(componentModel = "spring", uses = {LibroMapper.class})
public interface ReservaMapper {

    // Entity to dto
    @Mapping(source = "estado.nombre", target = "estado")
    ReservaResponse entityToDto(Reserva entity);

    List<ReservaResponse> listEntityToListDto(List<Reserva> list);
}
