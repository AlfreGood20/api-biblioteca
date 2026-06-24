package com.api.biblioteca.services.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.api.biblioteca.dtos.request.NacionalidadRequest;
import com.api.biblioteca.exceptions.ResourceNotFoundException;
import com.api.biblioteca.models.Nacionalidad;
import com.api.biblioteca.repositorys.NacionalidadRepository;
import com.api.biblioteca.services.NacionalidadService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NacionalidadServiceImpl implements NacionalidadService {

    private final NacionalidadRepository nacionalidadRepository;
    
    @Override
    public Nacionalidad crearNueva(NacionalidadRequest request) {
        return nacionalidadRepository.save(
            Nacionalidad.builder()
                .nombre(request.nombre())
                .build()
        );
    }

    @Override
    public List<Nacionalidad> obtenerNacionalidades() {
        return nacionalidadRepository.findAll();
    }

    @Override
    public Nacionalidad obtenerNacionalidadPorId(Long id) {
        return nacionalidadRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Nacionalidad no encontrada"));
    }

    @Override
    public void eliminarNacionalidadPorId(Long id) {
        nacionalidadRepository.delete(obtenerNacionalidadPorId(id));
    }
}
