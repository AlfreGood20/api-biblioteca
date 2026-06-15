package com.api.biblioteca.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.biblioteca.models.TipoTelefono;

@Repository
public interface TipoTelefonoRepository extends JpaRepository<TipoTelefono, Long> {

}
