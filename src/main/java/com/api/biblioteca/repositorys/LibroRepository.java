package com.api.biblioteca.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.biblioteca.models.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

}
