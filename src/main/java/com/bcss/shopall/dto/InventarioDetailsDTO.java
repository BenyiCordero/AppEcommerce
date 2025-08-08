package com.bcss.shopall.dto;

import com.bcss.shopall.domain.Producto;
import jakarta.validation.constraints.NotNull;

public record InventarioDetailsDTO(
        @NotNull(message = "El producto no puede ser nulo")
        Producto producto,
        @NotNull(message = "La cantidad no puede ser nula")
        Integer cantidad
) {
}
