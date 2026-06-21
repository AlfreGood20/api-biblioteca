package com.api.biblioteca.exceptions;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ResponseExeption {
    private int status;
    private String error;
    private Object menssaje;
    private String uri;
    private LocalDateTime timestamp;
}