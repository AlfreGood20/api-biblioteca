package com.api.biblioteca.dtos.request;

import jakarta.validation.constraints.NotBlank;

public record NacionalidadRequest
(
    @NotBlank(message = "Es obligatorio")
    String nombre
) {
}
