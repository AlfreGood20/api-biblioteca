package com.api.biblioteca.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.biblioteca.models.Municipio;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Long> {

}
