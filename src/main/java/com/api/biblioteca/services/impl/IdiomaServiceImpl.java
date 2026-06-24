package com.api.biblioteca.services.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.api.biblioteca.dtos.request.IdiomaRequest;
import com.api.biblioteca.exceptions.ResourceNotFoundException;
import com.api.biblioteca.models.Idioma;
import com.api.biblioteca.repositorys.IdiomaRepository;
import com.api.biblioteca.services.IdiomaService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IdiomaServiceImpl implements IdiomaService {

    private final IdiomaRepository idiomaRepository;
    
    @Override
    public Idioma crearNuevo(IdiomaRequest request) {
        return idiomaRepository.save(
            Idioma.builder()
                .nombre(request.nombre())
                .build()
        );
    }

    @Override
    public List<Idioma> obtenerIdiomas() {
        return idiomaRepository.findAll();
    }

    @Override
    public Idioma obtenerIdiomaPorId(Long id) {
        return idiomaRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Idioma no encontrado"));
    }

    @Override
    public void eliminarIdiomaPorId(Long id) {
        idiomaRepository.delete(obtenerIdiomaPorId(id));
    }
}
