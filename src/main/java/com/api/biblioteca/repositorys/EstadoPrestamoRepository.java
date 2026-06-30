package com.api.biblioteca.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.biblioteca.models.EstadoPrestamo;
import java.util.Optional;

import com.api.biblioteca.enums.EstadoPrestamoNombre;


@Repository
public interface EstadoPrestamoRepository extends JpaRepository<EstadoPrestamo, Long> {

    Optional<EstadoPrestamo> findByNombre(EstadoPrestamoNombre nombre);
}
