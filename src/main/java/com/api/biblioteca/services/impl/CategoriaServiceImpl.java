package com.api.biblioteca.services.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.api.biblioteca.dtos.request.CategoriaRequest;
import com.api.biblioteca.exceptions.ResourceNotFoundException;
import com.api.biblioteca.models.Categoria;
import com.api.biblioteca.repositorys.CategoriaRepository;
import com.api.biblioteca.services.CategoriaService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService{

    private final CategoriaRepository categoriaRepository;
    
    @Override
    public Categoria crearNuevo(CategoriaRequest request) {
        return categoriaRepository.save(
            Categoria.builder()
                .nombre(request.nombre())
                .descripcion(request.descripcion())
                .build()
        );
    }

    @Override
    public List<Categoria> obtenerCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria obtenerCategoriaPorId(Long id) {
        return categoriaRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Categoria no encontrado"));
    }

    @Override
    public void eliminarCategoriaPorId(Long id) {
        categoriaRepository.delete(obtenerCategoriaPorId(id));
    }
}
