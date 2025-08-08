package com.bcss.shopall.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ProductoDTO(
        @NotBlank(message = "La descripcion no puede estar en blanco")
        String descripcion,
        @NotBlank(message = "El codigo no puede estar en blanco")
        String codigo,
        @NotNull(message = "El id de la categoria no puede ser nulo")
        Long idCategoria,
        @NotNull(message = "El id del inventario no puede ser nulo")
        Long idInventario,
        @NotNull(message = "El precio no puede ser nulo")
        Double precio,
        @NotNull(message = "La cantidad no puede ser nulo")
        Integer cantidad
) {
}
