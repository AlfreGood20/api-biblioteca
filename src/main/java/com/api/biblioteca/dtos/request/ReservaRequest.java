package com.api.biblioteca.dtos.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ReservaRequest
(
    @NotNull(message = "Es obligatorio")
    @Positive(message = "El valor tiene que ser positivo")
    Long usuarioId,

    @NotNull(message = "Es obligatorio")
    @Positive(message = "El valor tiene que ser positivo")
    Long libroId
) {
}