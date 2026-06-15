package com.api.biblioteca.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.biblioteca.models.EstadoPrestamo;

@Repository
public interface EstadoPrestamoRepository extends JpaRepository<EstadoPrestamo, Long> {

}
