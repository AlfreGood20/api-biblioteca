package com.api.biblioteca.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.biblioteca.dtos.request.LoginRequest;
import com.api.biblioteca.dtos.request.UsuarioPublicRequest;
import com.api.biblioteca.dtos.response.TokenResponse;
import com.api.biblioteca.dtos.response.UsuarioResponse;
import com.api.biblioteca.services.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> autenticarse(@Valid @RequestBody LoginRequest request, HttpServletResponse response) {
        return ResponseEntity.ok(authService.iniciarSession(request, response));
    }
    
    @PostMapping("/logout")
    public ResponseEntity<Void> salirSession(HttpServletRequest request, HttpServletResponse response) {
        authService.salirSession(request, response);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/refresh")
    public ResponseEntity<TokenResponse> refrescarToken(HttpServletRequest request, HttpServletResponse response) {
        return ResponseEntity.ok(authService.refrescarToken(request, response));
    }

    @PostMapping("/register")
    public ResponseEntity<UsuarioResponse> registrarse(@Valid @RequestBody UsuarioPublicRequest request) {
        return ResponseEntity.ok(authService.registrarse(request));
    }
}