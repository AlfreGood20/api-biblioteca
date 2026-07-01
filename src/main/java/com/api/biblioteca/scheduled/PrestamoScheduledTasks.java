package com.api.biblioteca.scheduled;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.api.biblioteca.enums.EstadoMultaNombre;
import com.api.biblioteca.enums.EstadoPrestamoNombre;
import com.api.biblioteca.exceptions.ResourceNotFoundException;
import com.api.biblioteca.models.EstadoMulta;
import com.api.biblioteca.models.EstadoPrestamo;
import com.api.biblioteca.models.Multa;
import com.api.biblioteca.models.Prestamo;
import com.api.biblioteca.repositorys.EstadoMultaRepository;
import com.api.biblioteca.repositorys.EstadoPrestamoRepository;
import com.api.biblioteca.repositorys.MultaRepository;
import com.api.biblioteca.repositorys.PrestamoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class PrestamoScheduledTasks {

    private final PrestamoRepository prestamoRepository;
    private final EstadoPrestamoRepository estadoPrestamoRepository;
    private final MultaRepository multaRepository;
    private final EstadoMultaRepository estadoMultaRepository;

    private final BigDecimal COSTO_POR_DIA = new BigDecimal("15.00");

    @EventListener(ApplicationReadyEvent.class)
    public void alIniciar() {
        log.info("Revisando préstamos vencidos y multas actulizar al iniciar...");
        consultarPrestamosVencidosYGenerarMultas();
    }

    @Scheduled(cron = "0 0 1 * * *")
    @Transactional
    public void consultarPrestamosVencidosYGenerarMultas(){
        log.info("Ejecutando revisión de préstamos vencidos...");

        List<Prestamo> prestamosVencidos = 
            prestamoRepository.findByEstado_NombreAndFechaLimiteBefore(EstadoPrestamoNombre.ACTIVO, LocalDate.now());

        EstadoPrestamo estadoVencido = estadoPrestamoRepository.findByNombre(EstadoPrestamoNombre.VENCIDO)
            .orElseThrow(()-> new ResourceNotFoundException("Estado prestamo no encontrado"));
        
        EstadoMulta estadoPendiente = estadoMultaRepository.findByNombre(EstadoMultaNombre.PENDIENTE)
            .orElseThrow(()-> new ResourceNotFoundException("Estado multa no encontrado"));
        
        for (Prestamo prestamo : prestamosVencidos) {
            prestamo.setEstado(estadoVencido);

            log.info("Generar multas...");
            int diasRetraso = (int) ChronoUnit.DAYS.between(prestamo.getFechaLimite(), LocalDate.now());
            BigDecimal importe = COSTO_POR_DIA.multiply(BigDecimal.valueOf(diasRetraso));


            Multa multa = Multa.builder()
                .diasRetraso(diasRetraso)
                .importe(importe)
                .prestamo(prestamo)
                .estado(estadoPendiente)
                .build();

            multaRepository.save(multa);
        }

        prestamoRepository.saveAll(prestamosVencidos);

        List<Prestamo> prestamosVencidosActulizar = prestamoRepository.findByEstado_Nombre(EstadoPrestamoNombre.VENCIDO);

        for (Prestamo prestamo : prestamosVencidosActulizar) {
            Multa multa = prestamo.getMulta();

            if(multa.getEstado().getNombre() == EstadoMultaNombre.PENDIENTE && multa != null){
                int diasRetraso = (int) ChronoUnit.DAYS.between(prestamo.getFechaLimite(), LocalDate.now());
                BigDecimal importe = COSTO_POR_DIA.multiply(BigDecimal.valueOf(diasRetraso));

                multa.setDiasRetraso(diasRetraso);
                multa.setImporte(importe);
                multaRepository.save(multa);
            }
        }
        
    }
}
