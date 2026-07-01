package com.api.biblioteca.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.biblioteca.models.EstadoMulta;
import java.util.List;
import com.api.biblioteca.enums.EstadoMultaNombre;


@Repository
public interface EstadoMultaRepository extends JpaRepository<EstadoMulta, Long> {

    Optional<EstadoMulta> findByNombre(EstadoMultaNombre nombre);
}
