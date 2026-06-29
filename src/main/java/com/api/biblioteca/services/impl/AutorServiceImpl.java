package com.api.biblioteca.services.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.api.biblioteca.dtos.request.AutorRequest;
import com.api.biblioteca.dtos.response.AutorResponse;
import com.api.biblioteca.exceptions.BusinessExeption;
import com.api.biblioteca.exceptions.ResourceNotFoundException;
import com.api.biblioteca.mappers.AutorMapper;
import com.api.biblioteca.models.Autor;
import com.api.biblioteca.models.Nacionalidad;
import com.api.biblioteca.repositorys.AutorRepository;
import com.api.biblioteca.repositorys.NacionalidadRepository;
import com.api.biblioteca.services.AutorService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AutorServiceImpl implements AutorService{

    private final AutorMapper autorMapper;

    private final AutorRepository autorRepository;
    private final NacionalidadRepository nacionalidadRepository;
    

    @Override
    public AutorResponse crearNuevo(AutorRequest request) {
        Autor autor = autorMapper.dtoToEntity(request);

        Nacionalidad nacionalidad = buscarNacionalidadPorId(request.nacionalidadId());

        autor.setNacionalidad(nacionalidad);
        return autorMapper.entityToDto(autorRepository.save(autor));
    }

    @Override
    public List<AutorResponse> obtenerAutores(String nombre, String apellidoPaterno, String apellidoMaterno, Long nacionalidadId) {
        return autorMapper.listEntityToListDto(autorRepository.findByFiltros(nombre, apellidoPaterno, apellidoMaterno, nacionalidadId));
    }

    @Override
    public AutorResponse obtenerAutorPorId(Long id) {
        return autorMapper.entityToDto(buscarAutorPorId(id));
    }

    @Override
    public AutorResponse actualizarAutorPorId(AutorRequest request, Long id) {
        Autor autor = buscarAutorPorId(id);
        
        Nacionalidad nacionalidad = buscarNacionalidadPorId(request.nacionalidadId());

        autor.setNombre(request.nombre());
        autor.setApellidoPaterno(request.apellidoPaterno());
        autor.setApellidoMaterno(request.apellidoMaterno());
        autor.setNacionalidad(nacionalidad);

        return autorMapper.entityToDto(autorRepository.save(autor));
    }

    @Override
    public void eliminarAutorPorId(Long id) {
        Autor autor = buscarAutorPorId(id);

        if(!autor.getLibros().isEmpty()){
            throw new BusinessExeption("Este autor tiene relaciones con libros, no se puede eliminar");
        }

        autorRepository.delete(autor);
    }




    // FUNCIONES REUTILIZABLES
    private Nacionalidad buscarNacionalidadPorId(Long id){
        return nacionalidadRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Nacionalidad no encontrada"));
    }

    private Autor buscarAutorPorId(Long id){
        return autorRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Autor no encontrado"));
    }

}
