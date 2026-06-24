package com.api.biblioteca.services;

import java.util.List;
import com.api.biblioteca.dtos.request.CategoriaRequest;
import com.api.biblioteca.models.Categoria;

public interface CategoriaService {

    Categoria crearNuevo(CategoriaRequest request);
    List<Categoria> obtenerCategorias();
    Categoria obtenerCategoriaPorId(Long id);
    void eliminarCategoriaPorId(Long id);
}
