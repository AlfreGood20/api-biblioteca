package com.api.biblioteca.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.biblioteca.models.EstadoUsuario;
import com.api.biblioteca.enums.EstadoUsuarioNombre;


@Repository
public interface EstadoUsuarioRepository extends JpaRepository<EstadoUsuario, Long> {

    Optional<EstadoUsuario> findByNombre(EstadoUsuarioNombre nombre);
}
