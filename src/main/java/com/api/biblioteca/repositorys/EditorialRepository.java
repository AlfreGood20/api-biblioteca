package com.api.biblioteca.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.biblioteca.models.Editorial;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Long> {

}
