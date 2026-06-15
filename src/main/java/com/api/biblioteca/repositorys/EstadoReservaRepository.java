package com.api.biblioteca.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.biblioteca.models.EstadoReserva;

@Repository
public interface EstadoReservaRepository extends JpaRepository<EstadoReserva, Long> {

}
