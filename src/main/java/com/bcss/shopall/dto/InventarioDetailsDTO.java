package com.bcss.shopall.dto;

import com.bcss.shopall.domain.Producto;

public record InventarioDetailsDTO(
        Producto producto,
        Integer cantidad
) {
}
