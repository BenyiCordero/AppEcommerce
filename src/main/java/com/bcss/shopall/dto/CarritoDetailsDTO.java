package com.bcss.shopall.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CarritoDetailsDTO (
        @NotNull(message = "El ID del carrito no puede ser nulo")
        Long idCarrito,
        @NotNull(message = "El ID del producto no puede ser nulo")
        Long idProducto,
        @NotNull(message = "La cantidad no puede ser nula")
        Integer cantidad
){
}
