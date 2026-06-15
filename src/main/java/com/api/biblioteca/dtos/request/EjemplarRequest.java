package com.api.biblioteca.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record EjemplarRequest
(
    @NotBlank(message = "Es obligatorio")
    String codigo,

    @NotNull(message = "Es obligatorio")
    @Positive(message = "El valor tiene que ser positivo")
    @JsonProperty("estado_id")
    Long estadoId
) {
}