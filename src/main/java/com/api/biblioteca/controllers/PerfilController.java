package com.api.biblioteca.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.biblioteca.configurations.CustomUserDetails;
import com.api.biblioteca.dtos.response.UsuarioResponse;
import com.api.biblioteca.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/usuarios/perfil")
@RequiredArgsConstructor
public class PerfilController {

    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<UsuarioResponse> obtenerPerfil(@AuthenticationPrincipal CustomUserDetails usuario) {
        return ResponseEntity.ok(usuarioService.obtenerPerfil(usuario));
    }
    
}