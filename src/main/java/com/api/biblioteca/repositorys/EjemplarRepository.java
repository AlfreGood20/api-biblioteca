package com.api.biblioteca.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.api.biblioteca.models.Ejemplar;

@Repository
public interface EjemplarRepository extends JpaRepository<Ejemplar, Long> {

    
    @Query("""
        SELECT e FROM Ejemplar e
        WHERE (:libroId IS NULL OR e.libro.id = :libroId)
        AND (:codigo IS NULL OR LOWER(e.codigo) LIKE LOWER(CONCAT('%', :codigo, '%')))
        AND (:estadoId IS NULL OR e.estado.id = :estadoId)
    """)
    List<Ejemplar> findByFiltros(
        @Param("libroId") Long libroId,
        @Param("codigo") String codigo,
        @Param("estadoId") Long estadoId
    );
}
