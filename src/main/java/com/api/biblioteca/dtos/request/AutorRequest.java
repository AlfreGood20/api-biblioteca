package com.api.biblioteca.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AutorRequest
(
    @NotEmpty(message = "Es obligatorio")
    String nombre,

    @NotEmpty(message = "Es obligatorio")
    @JsonProperty("apellido_paterno")
    String apellidoPaterno,

    @NotEmpty(message = "Es obligatorio")
    @JsonProperty("apellido_materno")
    String apellidoMaterno,

    @NotNull(message = "Es obligatorio")
    @Positive(message = "El valor tiene que ser positivo")
    @JsonProperty("nacionalidad_id")
    Long nacionalidadId
) {
}