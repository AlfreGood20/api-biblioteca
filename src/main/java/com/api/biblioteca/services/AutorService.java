package com.api.biblioteca.services;

import java.util.List;
import com.api.biblioteca.dtos.request.AutorRequest;
import com.api.biblioteca.dtos.response.AutorResponse;

public interface AutorService {

    AutorResponse crearNuevo(AutorRequest request);

    List<AutorResponse> obtenerAutores(String nombre, String apellidoPaterno, String apellidoMaterno, Long nacionalidadId);

    AutorResponse obtenerAutorPorId(Long id);

    AutorResponse actualizarAutorPorId(AutorRequest request, Long id);

    void eliminarAutorPorId(Long id);
}