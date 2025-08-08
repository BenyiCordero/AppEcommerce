package com.bcss.shopall.dto;

import jakarta.validation.constraints.NotNull;

public record VentaDTO (
        @NotNull(message = "La cantidad no puede ser nula")
        Integer cantidad,
        @NotNull(message = "El id del producto no puede ser nulo")
        Long id_producto,
        @NotNull(message = "El id de la venta no puede ser nulo")
        Long id_venta,
        @NotNull(message = "El id del metodo no puede ser nulo")
        Long id_metodo,
        @NotNull(message = "La cantidad de la venta no puede ser nula")
        Long cantidad_m
){
}
