package com.api.biblioteca.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.biblioteca.models.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

}
