package com.api.biblioteca.services;

import java.util.List;
import com.api.biblioteca.dtos.response.MultaResponse;

public interface MultaService {

    List<MultaResponse> obtenerMultas(Long estadoId);

    MultaResponse pagarMulta(Long id);

    MultaResponse obtenerMultaPorId(Long id);
}