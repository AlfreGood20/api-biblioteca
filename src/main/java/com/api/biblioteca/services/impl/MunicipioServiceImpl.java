package com.api.biblioteca.services.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.api.biblioteca.exceptions.ResourceNotFoundException;
import com.api.biblioteca.models.Municipio;
import com.api.biblioteca.repositorys.MunicipioRepository;
import com.api.biblioteca.services.MunicipioService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MunicipioServiceImpl implements MunicipioService {

    private final MunicipioRepository municipioRepository;
    
    @Override
    public Municipio crearNuevo(Municipio request) {
        return municipioRepository.save(request);
    }

    @Override
    public List<Municipio> obtenerMunicipios() {
        return municipioRepository.findAll();
    }

    @Override
    public Municipio obtenerMunicipioPorId(Long id) {
        return municipioRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Municipio no encontrado"));
    }

    @Override
    public void eliminarMunicipioPorId(Long id) {
        municipioRepository.delete(obtenerMunicipioPorId(id));
    }
}
