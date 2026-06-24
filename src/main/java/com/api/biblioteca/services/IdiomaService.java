package com.api.biblioteca.services;

import java.util.List;
import com.api.biblioteca.dtos.request.IdiomaRequest;
import com.api.biblioteca.models.Idioma;

public interface IdiomaService {

    Idioma crearNuevo(IdiomaRequest request);
    List<Idioma> obtenerIdiomas();
    Idioma obtenerIdiomaPorId(Long id);
    void eliminarIdiomaPorId(Long id);
}
