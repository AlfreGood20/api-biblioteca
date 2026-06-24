package com.api.biblioteca.services;

import java.util.List;

import com.api.biblioteca.dtos.request.EditorialRequest;
import com.api.biblioteca.models.Editorial;

public interface EditorialService {

    Editorial crearNuevo(EditorialRequest request);
    List<Editorial> obtenerEditoriales();
    Editorial obtenerEditorialPorId(Long id);
    void eliminarEditorialPorId(Long id);
}
