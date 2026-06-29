package com.api.biblioteca.dtos.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LibroResponse
(
    Long id,
    String titulo,
    String sinopsis,
    String isbn,
    @JsonProperty("numero_paginas")
    int numeroPaginas,
    int anio,
    @JsonProperty("portada_url")
    String portadaUrl,
    String categoria,
    String editorial,
    String idioma,
    List<AutorResponse> autores
) {
}