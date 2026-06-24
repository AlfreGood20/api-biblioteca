package com.api.biblioteca.services;

import java.util.List;

import com.api.biblioteca.models.Municipio;

public interface MunicipioService {

    Municipio crearNuevo(Municipio request);
    List<Municipio> obtenerMunicipios();
    Municipio obtenerMunicipioPorId(Long id);
    void eliminarMunicipioPorId(Long id);
}