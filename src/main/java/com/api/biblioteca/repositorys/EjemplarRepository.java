package com.api.biblioteca.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.biblioteca.models.Ejemplar;

@Repository
public interface EjemplarRepository extends JpaRepository<Ejemplar, Long> {

}
