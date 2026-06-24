package com.api.biblioteca.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.biblioteca.dtos.request.EditorialRequest;
import com.api.biblioteca.models.Editorial;
import com.api.biblioteca.services.EditorialService;
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
@RequestMapping("api/editoriales")
@RequiredArgsConstructor
public class EditorialController {

    private final EditorialService editorialService;

    @PostMapping("/")
    public ResponseEntity<Editorial> crearNuevo(@Valid @RequestBody EditorialRequest request) {
        return new ResponseEntity<Editorial>(editorialService.crearNuevo(request), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Editorial>> obtenerEditoriales() {
        return ResponseEntity.ok().body(editorialService.obtenerEditoriales());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Editorial> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(editorialService.obtenerEditorialPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id){
        editorialService.eliminarEditorialPorId(id);
        return ResponseEntity.noContent().build();
    }
}