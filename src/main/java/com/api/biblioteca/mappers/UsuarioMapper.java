package com.api.biblioteca.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.api.biblioteca.dtos.response.UsuarioResponse;
import com.api.biblioteca.dtos.response.UsuarioResumen;
import com.api.biblioteca.models.Usuario;

@Mapper(componentModel = "spring", uses = {TelefonoMapper.class, DireccionMapper.class})
public interface UsuarioMapper {

    // Entity To Dto
    @Mapping(source = "estado.nombre", target = "estado")
    @Mapping(source = "rol.nombre", target = "rol")
    @Mapping(target = "correo", ignore = true)
    UsuarioResponse entityToDto(Usuario entity);

    @Mapping(target = "correo", ignore = true)
    UsuarioResumen entirtyToResumen(Usuario entity);

    List<UsuarioResponse> listEntityToListDto(List<Usuario> list);
}
