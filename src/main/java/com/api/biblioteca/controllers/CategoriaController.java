package com.api.biblioteca.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.biblioteca.dtos.request.CategoriaRequest;
import com.api.biblioteca.models.Categoria;
import com.api.biblioteca.services.CategoriaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("api/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping("/")
    public ResponseEntity<Categoria> crearNuevo(@Valid @RequestBody CategoriaRequest request) {
        return new ResponseEntity<Categoria>(categoriaService.crearNuevo(request), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Categoria>> obtenerCategorias() {
        return ResponseEntity.ok().body(categoriaService.obtenerCategorias());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(categoriaService.obtenerCategoriaPorId(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id){
        categoriaService.eliminarCategoriaPorId(id);
        return ResponseEntity.noContent().build();
    }
    

}
