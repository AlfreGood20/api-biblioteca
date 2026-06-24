package com.api.biblioteca.services.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.api.biblioteca.dtos.response.EjemplarResponse;
import com.api.biblioteca.dtos.updates.EstadoRequest;
import com.api.biblioteca.repositorys.EjemplarRepository;
import com.api.biblioteca.services.EjemplarService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EjemplarServiceImpl implements EjemplarService{

    private final EjemplarRepository ejemplarRepository;

    @Override
    public EjemplarResponse crearNuevo(Long libroId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearNuevo'");
    }

    @Override
    public List<EjemplarResponse> obtenerEjemplares(Long libroId, String codigo, Long estadoId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerEjemplares'");
    }

    @Override
    public EjemplarResponse obtenerEjemplarPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerEjemplarPorId'");
    }

    @Override
    public EjemplarResponse cambiarEstadoEjemplarPorId(EstadoRequest request, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cambiarEstadoEjemplarPorId'");
    }

    @Override
    public void eliminarEjemplarPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarEjemplarPorId'");
    }

}
