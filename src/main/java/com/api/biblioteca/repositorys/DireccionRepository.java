package com.api.biblioteca.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.biblioteca.models.Direccion;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long> {

}
