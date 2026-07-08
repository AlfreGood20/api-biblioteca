package com.api.biblioteca.services;

import com.api.biblioteca.dtos.request.LoginRequest;
import com.api.biblioteca.dtos.request.UsuarioPublicRequest;
import com.api.biblioteca.dtos.response.TokenResponse;
import com.api.biblioteca.dtos.response.UsuarioResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthService {

    TokenResponse iniciarSession(LoginRequest request, HttpServletResponse response);

    void salirSession(HttpServletRequest request, HttpServletResponse response);

    UsuarioResponse registrarse(UsuarioPublicRequest request);

    TokenResponse refrescarToken(HttpServletRequest request, HttpServletResponse response);
}