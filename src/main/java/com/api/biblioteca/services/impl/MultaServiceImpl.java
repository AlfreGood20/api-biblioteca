package com.api.biblioteca.services.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.api.biblioteca.dtos.response.MultaResponse;
import com.api.biblioteca.repositorys.MultaRepository;
import com.api.biblioteca.services.MultaService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MultaServiceImpl implements MultaService{
    
    private final MultaRepository multaRepository;
    
    @Override
    public MultaResponse crearMultas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearMultas'");
    }

    @Override
    public List<MultaResponse> obtenerMultas(Long estadoId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerMultas'");
    }

    @Override
    public MultaResponse pagarMulta(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pagarMulta'");
    }

    @Override
    public MultaResponse obtenerMultaPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerMultaPorId'");
    }
}
