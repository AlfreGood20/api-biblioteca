package com.api.biblioteca.services.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.api.biblioteca.dtos.request.AutorRequest;
import com.api.biblioteca.dtos.response.AutorResponse;
import com.api.biblioteca.repositorys.AutorRepository;
import com.api.biblioteca.services.AutorService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AutorServiceImpl implements AutorService{

    private final AutorRepository autorRepository;

    @Override
    public AutorResponse crearNuevo(AutorRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearNuevo'");
    }

    @Override
    public List<AutorResponse> obtenerAutores(String nombre, String apellidoPaterno, String apellidoMaterno,
            Long nacionalidadId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerAutores'");
    }

    @Override
    public AutorResponse obtenerAutorPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerAutorPorId'");
    }

    @Override
    public AutorResponse actualizarAutorPorId(AutorRequest request, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarAutorPorId'");
    }

    @Override
    public void eliminarAutorPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarAutorPorId'");
    }

}
