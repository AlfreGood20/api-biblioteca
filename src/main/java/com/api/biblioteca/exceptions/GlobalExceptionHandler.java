package com.api.biblioteca.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //400 VALIDACION DE NEGOCIO
    public ResponseEntity<?> busineesProblem(BusinessExeption ex, HttpServletRequest request){

        ResponseExeption response = ResponseExeption.builder()
            .status(HttpStatus.BAD_REQUEST.value())
            .error("Conflicto de recurso")
            .menssaje(ex.getMessage())
            .timestamp(LocalDateTime.now())
            .build();


        return ResponseEntity.badRequest().body(response);
    }

    //400 VALIDACIONES DE FORMULARIO
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> badRequest(MethodArgumentNotValidException ex, HttpServletRequest request){

        Map<String, String> mensaje = new HashMap<>();
        ex.getFieldErrors().stream().forEach(error -> mensaje.put(error.getField(), error.getDefaultMessage()));

        ResponseExeption response = ResponseExeption.builder()
            .status(HttpStatus.BAD_REQUEST.value())
            .error("Datos invalidos")
            .menssaje(mensaje)
            .uri(request.getRequestURI())
            .timestamp(LocalDateTime.now())
            .build();

        return ResponseEntity.badRequest().body(response);
    }

    //404 PARA MANEJAR USERNAME NO ENCONTRADO (CORREO NO ENCONTRADO)
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<?> usernameNotFound(UsernameNotFoundException ex, HttpServletRequest request){

        ResponseExeption response = ResponseExeption.builder()
            .status(HttpStatus.NOT_FOUND.value())
            .error("Correo no encontrado")
            .menssaje("Correo aun no se encuentra registrado en el sistema.")
            .uri(request.getRequestURI())
            .timestamp(LocalDateTime.now())
            .build();
            
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    //404
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> notFound(ResourceNotFoundException ex, HttpServletRequest request){

        ResponseExeption response = ResponseExeption.builder()
            .status(HttpStatus.NOT_FOUND.value())
            .error("Recurso No Encontrado")
            .menssaje(ex.getMessage())
            .uri(request.getRequestURI())
            .timestamp(LocalDateTime.now())
            .build();

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    //405
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<?> methodNotAllowed(HttpServletRequest request){

        ResponseExeption response = ResponseExeption.builder()
            .status(HttpStatus.METHOD_NOT_ALLOWED.value())
            .error("Metodo no soportado")
            .menssaje("Este enpoint no soporta"+ request.getMethod())
            .uri(request.getRequestURI())
            .timestamp(LocalDateTime.now())
            .build();

        return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
    }

    //500
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> manejarErrorInesperado(Exception ex, HttpServletRequest request){

        ResponseExeption mensaje= ResponseExeption.builder()
            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .error("Error inesperado")
            .menssaje(ex.getMessage())
            .uri(request.getRequestURI())
            .timestamp(LocalDateTime.now())
            .build();
        
        return ResponseEntity.internalServerError().body(mensaje);
    }


}