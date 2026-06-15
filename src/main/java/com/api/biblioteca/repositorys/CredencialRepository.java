package com.api.biblioteca.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.biblioteca.models.Credencial;

@Repository
public interface CredencialRepository extends JpaRepository<Credencial, Long> {

}
