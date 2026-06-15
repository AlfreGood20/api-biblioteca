package com.api.biblioteca.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.biblioteca.models.Multa;

@Repository
public interface MultaRepository extends JpaRepository<Multa, Long> {

}
