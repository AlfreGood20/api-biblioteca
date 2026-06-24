package com.api.biblioteca.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.biblioteca.dtos.request.NacionalidadRequest;
import com.api.biblioteca.models.Nacionalidad;
import com.api.biblioteca.services.NacionalidadService;
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
@RequestMapping("api/nacionalidades")
@RequiredArgsConstructor
public class NacionalidadController {

    private final NacionalidadService nacionalidadService;

    @PostMapping("/")
    public ResponseEntity<Nacionalidad> crearNuevo(@Valid @RequestBody NacionalidadRequest request) {
        return new ResponseEntity<Nacionalidad>(nacionalidadService.crearNueva(request), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Nacionalidad>> obtenerNacionalidades() {
        return ResponseEntity.ok().body(nacionalidadService.obtenerNacionalidades());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Nacionalidad> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(nacionalidadService.obtenerNacionalidadPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id){
        nacionalidadService.eliminarNacionalidadPorId(id);
        return ResponseEntity.noContent().build();
    }
    

}
