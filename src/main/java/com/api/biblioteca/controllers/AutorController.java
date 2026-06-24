package com.api.biblioteca.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.biblioteca.dtos.request.AutorRequest;
import com.api.biblioteca.dtos.response.AutorResponse;
import com.api.biblioteca.services.AutorService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("api/autores")
@RequiredArgsConstructor
public class AutorController {

    private final AutorService autorService;

    @PostMapping("/")
    public ResponseEntity<AutorResponse> crearNuevo(@Valid @RequestBody AutorRequest request) {
        return new ResponseEntity<AutorResponse>(autorService.crearNuevo(request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorResponse> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(autorService.obtenerAutorPorId(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<AutorResponse>> obetenerAutores(
        @RequestParam(required = false) String nombre,
        @RequestParam(required = false) String apellidoPaterno,
        @RequestParam(required = false) String apellidoMaterno,
        @RequestParam(required = false) Long nacionalidadId
    ) {
        return ResponseEntity.ok().body(autorService.obtenerAutores(nombre, apellidoPaterno, apellidoMaterno, nacionalidadId));
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<AutorResponse> actulizarAutorPorId(@PathVariable Long id,@Valid AutorRequest request) {
        return ResponseEntity.ok().body(autorService.actualizarAutorPorId(request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id){
        autorService.eliminarAutorPorId(id);
        return ResponseEntity.noContent().build();
    }    
}