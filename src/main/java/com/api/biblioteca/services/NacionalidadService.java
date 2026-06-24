package com.api.biblioteca.services;

import java.util.List;
import com.api.biblioteca.dtos.request.NacionalidadRequest;
import com.api.biblioteca.models.Nacionalidad;

public interface NacionalidadService {

    Nacionalidad crearNueva(NacionalidadRequest request);
    List<Nacionalidad> obtenerNacionalidades();
    Nacionalidad obtenerNacionalidadPorId(Long id);
    void eliminarNacionalidadPorId(Long id);
}
