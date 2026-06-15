package com.api.biblioteca.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DireccionRequest
(

    @NotNull(message = "Es obligatorio")
    @Positive(message = "El valor tiene que ser positivo")
    @JsonProperty("municiopio_id")
    Long municipioId,

    @NotBlank(message = "Es obligatorio")
    String calle,

    @NotBlank(message = "Es obligatorio")
    String colonia,

    @JsonProperty("numero_exterior")
    String numeroExterior,

    @JsonProperty("numero_interior")
    String numeroInterior,

    @NotBlank(message = "Es obligatorio")
    @JsonProperty("codigo_postal")
    String codigoPostal
) {
}