package com.api.biblioteca.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.biblioteca.models.EstadoEjemplar;

@Repository
public interface EstadoEjemplarRepository extends JpaRepository<EstadoEjemplar, Long> {

}
