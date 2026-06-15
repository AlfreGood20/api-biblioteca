package com.api.biblioteca.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.biblioteca.models.EstadoMulta;

@Repository
public interface EstadoMultaRepository extends JpaRepository<EstadoMulta, Long> {

}
