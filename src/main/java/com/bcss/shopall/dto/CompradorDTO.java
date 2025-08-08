package com.bcss.shopall.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CompradorDTO(
        @NotBlank(message = "El nombre no puede estar en blanco")
        String nombre,
        @NotBlank(message = "El primer apellido no puede estar en blanco")
        String primerApellido,
        @NotBlank(message = "El nombre no puede estar en blanco")
        String segundoApellido,
        @NotBlank(message = "El nombre no puede estar en blanco")
        String direccion
) {
}
