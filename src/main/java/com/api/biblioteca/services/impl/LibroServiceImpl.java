package com.api.biblioteca.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.biblioteca.dtos.request.LibroRequest;
import com.api.biblioteca.dtos.response.AutorResponse;
import com.api.biblioteca.dtos.response.EjemplarResponse;
import com.api.biblioteca.dtos.response.LibroResponse;
import com.api.biblioteca.repositorys.LibroRepository;
import com.api.biblioteca.services.LibroService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LibroServiceImpl implements LibroService{
    
    private final LibroRepository libroRepository;

    @Override
    public LibroResponse crearNuevo(LibroRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearNuevo'");
    }

    @Override
    public List<LibroResponse> obtenerLibros(String titulo, String isbn, Long categoriaId, Long editorialId,
            Long idiomaId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerLibros'");
    }

    @Override
    public LibroResponse obtenerLibroPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerLibroPorId'");
    }

    @Override
    public List<AutorResponse> obtenerAutoresDeUnLibro(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerAutoresDeUnLibro'");
    }

    @Override
    public List<EjemplarResponse> obtenerEjemplaresLibroPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerEjemplaresLibroPorId'");
    }

    @Override
    public LibroResponse actualizarLibro(LibroRequest request, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarLibro'");
    }

    @Override
    public void eliminarLibroPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarLibroPorId'");
    }

}
