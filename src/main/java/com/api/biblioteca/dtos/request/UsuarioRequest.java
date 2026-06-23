package com.api.biblioteca.dtos.request;

import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UsuarioRequest
(
    @NotBlank(message = "Es obligatorio")
    String nombre,

    @NotBlank(message = "Es obligatorio")
    @JsonProperty("apellido_paterno")
    String apellidoPaterno,

    @NotBlank(message = "Es obligatorio")
    @JsonProperty("apellido_materno")
    String apellidoMaterno,

    @NotNull(message = "Es obligatorio")
    @JsonProperty("fecha_nacimiento")
    LocalDate fechaNacimiento,

    @NotBlank(message = "Es obligatorio")
    String genero,

    String fotoUrl,

    String curp,

    @NotNull(message = "Es obligatorio")
    @JsonProperty("rol_id")
    Long rolId,

    @Valid
    @NotEmpty(message = "Es obligatorio")
    List<TelefonoRequest> telefonos,

    @Valid
    @NotNull(message = "Es obligatorio")
    DireccionRequest direccion,

    @Valid
    @NotNull(message = "Es obligatorio")
    CredencialRequest credencial
) {
}