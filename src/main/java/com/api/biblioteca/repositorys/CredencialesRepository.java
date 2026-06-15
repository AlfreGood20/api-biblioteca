package com.api.biblioteca.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.biblioteca.models.Credenciales;

@Repository
public interface CredencialesRepository extends JpaRepository<Credenciales, Long> {

}
