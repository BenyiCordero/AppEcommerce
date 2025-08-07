package com.bcss.shopall.dto;

public record ProductoDTO(
        String descripcion,
        String codigo,
        Long idCategoria,
        Long idInventario,
        Double precio,
        Integer cantidad
) {
}
