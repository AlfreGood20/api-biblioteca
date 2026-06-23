package com.api.biblioteca.dtos.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public record UsuarioResponse
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
    String correo,
    @JsonProperty("fecha_registro")
    LocalDateTime fechaRegistro,
    @JsonProperty("foto_url")
    String fotoUrl,
    String rol,
    String estado,
    List<TelefonoResponse> telefonos,
    DireccionResponse direccion
) {
}