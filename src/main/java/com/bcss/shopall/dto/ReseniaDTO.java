package com.bcss.shopall.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record ReseniaDTO(
        @NotBlank(message = "La descripción no puede estar en blanco")
        String descripcion,
        @NotNull(message = "La fecha no puede ser nula")
        Date fecha,
        @NotNull(message = "El id del producto no puede ser nulo")
        Long idProducto
) {
}
