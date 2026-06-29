package com.api.biblioteca.services.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import com.api.biblioteca.dtos.response.EjemplarResponse;
import com.api.biblioteca.dtos.updates.EstadoRequest;
import com.api.biblioteca.enums.EstadoEjemplarNombre;
import com.api.biblioteca.exceptions.ResourceNotFoundException;
import com.api.biblioteca.mappers.EjemplarMapper;
import com.api.biblioteca.models.Ejemplar;
import com.api.biblioteca.models.EstadoEjemplar;
import com.api.biblioteca.models.Libro;
import com.api.biblioteca.repositorys.EjemplarRepository;
import com.api.biblioteca.repositorys.EstadoEjemplarRepository;
import com.api.biblioteca.repositorys.LibroRepository;
import com.api.biblioteca.services.EjemplarService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EjemplarServiceImpl implements EjemplarService{

    private final EjemplarRepository ejemplarRepository;
    private final LibroRepository libroRepository;
    private final EstadoEjemplarRepository estadoEjemplarRepository;

    private final EjemplarMapper ejemplarMapper;

    @Override
    public EjemplarResponse crearNuevo(Long libroId) {
        Libro libro = buscarLibroPorId(libroId);

        String numeroAletorio = UUID.randomUUID().toString()
            .replace("-","")
            .substring(0, 6)
            .toUpperCase();

        String codigo = "EJ-"+LocalDate.now().getYear()+"-"+numeroAletorio;

        Ejemplar ejemplar = Ejemplar.builder()
            .codigo(codigo)
            .libro(libro)
            .estado(buscarEstadoPorNombre(EstadoEjemplarNombre.DISPONIBLE))
            .build();

        return ejemplarMapper.entityToDto(ejemplarRepository.save(ejemplar));
    }

    @Override
    public List<EjemplarResponse> obtenerEjemplares(Long libroId, String codigo, Long estadoId) {
        return ejemplarMapper.listEntityToListDto(ejemplarRepository.findByFiltros(libroId, codigo, estadoId));
    }

    @Override
    public EjemplarResponse obtenerEjemplarPorId(Long id) {
        return ejemplarMapper.entityToDto(
            ejemplarRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Ejemplar no econytrado")));
    }

    @Override
    public EjemplarResponse cambiarEstadoEjemplarPorId(EstadoRequest request, Long id) {

        Ejemplar ejemplar = ejemplarRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Ejemplar no encontrado"));

        EstadoEjemplar estado = estadoEjemplarRepository.findById(request.id())
            .orElseThrow(()-> new ResourceNotFoundException("Estado no encontrado"));

        ejemplar.setEstado(estado);

        return ejemplarMapper.entityToDto(ejemplarRepository.save(ejemplar));
    }

    @Override
    public void eliminarEjemplarPorId(Long id) {
        Ejemplar ejemplar = ejemplarRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Ejemplar no encontrado"));

        ejemplarRepository.delete(ejemplar);
    }



    //FUNCIONES REUTILIZABLES
    private Libro buscarLibroPorId(Long id){
        return libroRepository.findById(id)
            .orElseThrow(()->new ResourceNotFoundException("Libro no encontrado"));
    }

    private EstadoEjemplar buscarEstadoPorNombre(EstadoEjemplarNombre nombre){
        return estadoEjemplarRepository.findByNombre(nombre)
            .orElseThrow(() -> new ResourceNotFoundException("Estado no encontrado"));
    }

}
