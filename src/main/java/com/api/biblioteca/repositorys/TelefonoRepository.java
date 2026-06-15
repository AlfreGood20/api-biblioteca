package com.api.biblioteca.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.biblioteca.models.Telefono;

@Repository
public interface TelefonoRepository extends JpaRepository<Telefono, Long> {

}
