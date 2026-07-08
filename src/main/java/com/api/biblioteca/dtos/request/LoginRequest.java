package com.api.biblioteca.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequest(

    @NotBlank(message = "Es obligatorio")
    @Email(message = "Correo invalido, no cumple con el formato.")
    String correo,

    @NotBlank(message = "Es obligatorio")
    String contrasena
) {
}