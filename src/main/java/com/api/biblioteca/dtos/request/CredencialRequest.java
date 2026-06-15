package com.api.biblioteca.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CredencialRequest
(
    @Email(message = "Correo invalido, ingrese uno valido")
    String correo,

    @NotBlank(message = "Es obligatorio")
    @Size(min = 7, max = 50, message = "Debe tener almenos 8 caracteres")
    String contrasena
) {
}
