package com.api.biblioteca.dtos.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record MultaResponse
(
    Long id,
    int diasRetraso,
    LocalDateTime fechaRegistro,
    BigDecimal costoUnitario,
    LocalDateTime fechaPago,
    BigDecimal importe,
    String estado
) {
}