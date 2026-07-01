package com.api.biblioteca.exceptions;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;



// 401
@Component
@RequiredArgsConstructor
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint{

    
    private final ObjectMapper objectMapper;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        
        response.setContentType("application/json");
        response.setStatus(401);

        ResponseExeption responseHttp = ResponseExeption.builder()
            .status(401)
            .error(HttpStatus.FORBIDDEN.getReasonPhrase())
            .menssaje("Sin permiso a este recurso")
            .uri(request.getRequestURI())
            .timestamp(LocalDateTime.now())
            .build();

        response.getWriter().write(objectMapper.writeValueAsString(responseHttp));
    }
}