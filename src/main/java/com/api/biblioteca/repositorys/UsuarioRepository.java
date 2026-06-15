package com.api.biblioteca.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.biblioteca.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
