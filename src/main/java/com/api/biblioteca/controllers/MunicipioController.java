package com.api.biblioteca.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.biblioteca.models.Municipio;
import com.api.biblioteca.services.MunicipioService;

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
@RequestMapping("api/municipios")
@RequiredArgsConstructor
public class MunicipioController {

    private final MunicipioService municipioService;

    @PostMapping("/")
    public ResponseEntity<Municipio> crearNuevo(@Valid @RequestBody Municipio request) {
        return new ResponseEntity<Municipio>(municipioService.crearNuevo(request), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Municipio>> obtenerMunicipios() {
        return ResponseEntity.ok().body(municipioService.obtenerMunicipios());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Municipio> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(municipioService.obtenerMunicipioPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id){
        municipioService.eliminarMunicipioPorId(id);
        return ResponseEntity.noContent().build();
    }
    

}
