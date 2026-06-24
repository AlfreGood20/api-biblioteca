package com.api.biblioteca.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.biblioteca.dtos.request.IdiomaRequest;
import com.api.biblioteca.models.Idioma;
import com.api.biblioteca.services.IdiomaService;
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
@RequestMapping("api/idiomas")
@RequiredArgsConstructor
public class IdiomaController {

    private final IdiomaService idiomaService;

    @PostMapping("/")
    public ResponseEntity<Idioma> crearNuevo(@Valid @RequestBody IdiomaRequest request) {
        return new ResponseEntity<Idioma>(idiomaService.crearNuevo(request), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Idioma>> obtenerIdiomas() {
        return ResponseEntity.ok().body(idiomaService.obtenerIdiomas());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Idioma> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(idiomaService.obtenerIdiomaPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id){
        idiomaService.eliminarIdiomaPorId(id);
        return ResponseEntity.noContent().build();
    }
    

}
