package com.api.biblioteca.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TokenResponse(

    @JsonProperty("token_access")
    String tokenAccess,
    String type
) {
}