package com.api.biblioteca.services;

import java.util.List;

import com.api.biblioteca.dtos.request.PrestamoRequest;
import com.api.biblioteca.dtos.response.PrestamoResponse;

public interface PrestamoService {

    List<PrestamoResponse> crearNuevo(PrestamoRequest request);

    List<PrestamoResponse> obtenerPrestamos(Long estadoId, Long usuarioAdminId, Long usuarioId);

    PrestamoResponse obtenerPrestamoPorId(Long id);

    PrestamoResponse devolverPrestamoPorId(Long id);
}
