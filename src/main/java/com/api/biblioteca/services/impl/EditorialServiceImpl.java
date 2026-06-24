package com.api.biblioteca.services.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.api.biblioteca.dtos.request.EditorialRequest;
import com.api.biblioteca.exceptions.ResourceNotFoundException;
import com.api.biblioteca.models.Editorial;
import com.api.biblioteca.repositorys.EditorialRepository;
import com.api.biblioteca.services.EditorialService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EditorialServiceImpl implements EditorialService {

    private final EditorialRepository editorialRepository;
    
    @Override
    public Editorial crearNuevo(EditorialRequest request) {
        return editorialRepository.save(
            Editorial.builder()
                .nombre(request.nombre())
                .build()
        );
    }

    @Override
    public List<Editorial> obtenerEditoriales() {
        return editorialRepository.findAll();
    }

    @Override
    public Editorial obtenerEditorialPorId(Long id) {
        return editorialRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Editorial no encontrada"));
    }

    @Override
    public void eliminarEditorialPorId(Long id) {
        editorialRepository.delete(obtenerEditorialPorId(id));
    }
}
