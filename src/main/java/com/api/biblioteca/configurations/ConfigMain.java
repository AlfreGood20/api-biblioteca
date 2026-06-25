package com.api.biblioteca.configurations;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;


@OpenAPIDefinition(
    info = @Info(
        title = "API - BIBLIOTECA",
        version = "1.0.0",
        description = "",
        contact = @Contact(name = "José Alfredo", email = "josealfredolopezdelacruz2@gmail.com")
    ),
    servers = {@Server(url = "http://localhost:8080/", description = "ENTORNO LOCAL")}
)

@Configuration
public class ConfigMain {

}
