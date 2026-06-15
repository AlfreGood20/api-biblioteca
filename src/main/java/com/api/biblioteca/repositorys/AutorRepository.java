package com.api.biblioteca.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.biblioteca.models.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

}
