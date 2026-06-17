package com.api.biblioteca.dtos.response;

public record DireccionResponse
(
    Long id,
    String calle,
    String colonia,
    String codigoPostal,
    String municipio,
    String numeroExterior,
    String numeroInterior
) {
}