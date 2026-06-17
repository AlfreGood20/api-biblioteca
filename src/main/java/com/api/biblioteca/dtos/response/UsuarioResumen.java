package com.api.biblioteca.dtos.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UsuarioResumen
(
    Long id,
    String nombre,
    @JsonProperty("apellido_paterno")
    String apellidoPaterno,
    @JsonProperty("apellido_materno")
    String apellidoMaterno,
    @JsonProperty("fecha_nacimiento")
    LocalDate fechaNacimiento,
    String genero,
    String curp,
    String correo
) {
}