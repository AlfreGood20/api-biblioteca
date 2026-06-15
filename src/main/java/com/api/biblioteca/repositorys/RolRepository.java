package com.api.biblioteca.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.biblioteca.models.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

}
