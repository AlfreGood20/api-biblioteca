package com.api.biblioteca.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import com.api.biblioteca.dtos.response.MultaResponse;
import com.api.biblioteca.enums.EstadoMultaNombre;
import com.api.biblioteca.exceptions.BusinessExeption;
import com.api.biblioteca.exceptions.ResourceNotFoundException;
import com.api.biblioteca.mappers.MultaMapper;
import com.api.biblioteca.models.EstadoMulta;
import com.api.biblioteca.models.Multa;
import com.api.biblioteca.repositorys.EstadoMultaRepository;
import com.api.biblioteca.repositorys.MultaRepository;
import com.api.biblioteca.services.MultaService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MultaServiceImpl implements MultaService{
    
    private final MultaRepository multaRepository;
    private final EstadoMultaRepository estadoMultaRepository;

    private final MultaMapper multaMapper;

    @Override
    public List<MultaResponse> obtenerMultas(Long estadoId) {
        return multaMapper.listEntityToListDto(multaRepository.buscarPorParametros(estadoId));
    }

    @Override
    public MultaResponse pagarMulta(Long id) {
        Multa multa = multaRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Multa no encontrada"));

        if(multa.getEstado().getNombre() != EstadoMultaNombre.PENDIENTE){
            throw new BusinessExeption("Esta multa se encuentra "+multa.getEstado().getNombre().toString());
        }

        multa.setFechaPago(LocalDateTime.now());
        multa.setEstado(null);

        EstadoMulta estadoPagado = estadoMultaRepository.findByNombre(EstadoMultaNombre.PAGADA)
            .orElseThrow(() -> new ResourceNotFoundException("Estado multa no encontrada"));

        multa.setEstado(estadoPagado);

        return multaMapper.entityToDto(multaRepository.save(multa));
    }

    @Override
    public MultaResponse obtenerMultaPorId(Long id) {
        return multaMapper.entityToDto(multaRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Multa no encontrada")));
    }
}
