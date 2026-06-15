package com.api.biblioteca.dtos.request;

import jakarta.validation.constraints.NotBlank;

public record CategoriaRequest
(
    @NotBlank(message = "Es obligatorio")
    String nombre,

    String descripcion
) {

}
