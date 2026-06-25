package com.api.biblioteca.services;

import java.util.List;

import com.api.biblioteca.dtos.request.ReservaRequest;
import com.api.biblioteca.dtos.response.ReservaResponse;

public interface ReservaService {


    ReservaResponse crearNuevo(ReservaRequest request);

    List<ReservaResponse> obtenerReservas(Long estadoId);

    ReservaResponse obtenerReservaPorId(Long id);

    void eliminarReservaPorId(Long id);

    
}
