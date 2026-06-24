package com.api.biblioteca.services;

import java.util.List;
import com.api.biblioteca.dtos.response.EjemplarResponse;
import com.api.biblioteca.dtos.updates.EstadoRequest;

public interface EjemplarService {

    EjemplarResponse crearNuevo(Long libroId);

    List<EjemplarResponse> obtenerEjemplares(Long libroId, String codigo, Long estadoId);

    EjemplarResponse obtenerEjemplarPorId(Long id);

    EjemplarResponse cambiarEstadoEjemplarPorId(EstadoRequest request, Long id);

    void eliminarEjemplarPorId(Long id);
}