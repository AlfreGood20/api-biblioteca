package com.api.biblioteca.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.biblioteca.models.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
