package com.api.biblioteca.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.biblioteca.models.Prestamo;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {

}
