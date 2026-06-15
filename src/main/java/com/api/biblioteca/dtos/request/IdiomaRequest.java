package com.api.biblioteca.dtos.request;

import jakarta.validation.constraints.NotBlank;

public record IdiomaRequest
(
    @NotBlank(message = "Es obligatorio")
    String nombre
) {
}
