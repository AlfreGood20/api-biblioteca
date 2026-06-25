package com.api.biblioteca.services.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.api.biblioteca.dtos.request.PrestamoRequest;
import com.api.biblioteca.dtos.response.PrestamoResponse;
import com.api.biblioteca.repositorys.PrestamoRepository;
import com.api.biblioteca.services.PrestamoService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrestamoServiceImpl implements PrestamoService{
    
    private final PrestamoRepository prestamoRepository;
    
    @Override
    public PrestamoResponse crearNuevo(PrestamoRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearNuevo'");
    }

    @Override
    public List<PrestamoResponse> obtenerPrestamos(Long estadoId, Long usuarioAdminId, Long usuarioId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerPrestamos'");
    }

    @Override
    public PrestamoResponse obtenerPrestamoPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerPrestamoPorId'");
    }

    @Override
    public PrestamoResponse devolverPrestamoPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'devolverPrestamoPorId'");
    }
    
}
