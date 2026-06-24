package com.api.biblioteca.services;

import java.util.List;
import com.api.biblioteca.dtos.request.LibroRequest;
import com.api.biblioteca.dtos.response.AutorResponse;
import com.api.biblioteca.dtos.response.EjemplarResponse;
import com.api.biblioteca.dtos.response.LibroResponse;

public interface LibroService {

    LibroResponse crearNuevo(LibroRequest request);

    List<LibroResponse> obtenerLibros(String titulo, String isbn, Long categoriaId, Long editorialId, Long idiomaId);

    LibroResponse obtenerLibroPorId(Long id);

    List<AutorResponse> obtenerAutoresDeUnLibro(Long id);

    List<EjemplarResponse> obtenerEjemplaresLibroPorId(Long id);

    LibroResponse actualizarLibro(LibroRequest request, Long id);

    void eliminarLibroPorId(Long id);
}