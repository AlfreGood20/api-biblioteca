package com.api.biblioteca.services.impl;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.biblioteca.dtos.request.ReservaRequest;
import com.api.biblioteca.dtos.response.ReservaResponse;
import com.api.biblioteca.repositorys.ReservaRepository;
import com.api.biblioteca.services.ReservaService;
import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("api/reservas")
@RequiredArgsConstructor
public class ReservaServiceImpl implements ReservaService{
    
    private final ReservaRepository reservaRepository;
    
    @Override
    public ReservaResponse crearNuevo(ReservaRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearNuevo'");
    }

    @Override
    public List<ReservaResponse> obtenerReservas(Long estadoId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerReservas'");
    }

    @Override
    public ReservaResponse obtenerReservaPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerReservaPorId'");
    }

    @Override
    public void eliminarReservaPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarReservaPorId'");
    }

}
