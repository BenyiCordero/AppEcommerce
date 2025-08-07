package com.bcss.shopall.dto;

public record VentaDTO (
        Integer cantidad,
        Long id_producto,
        Long id_venta,
        Long id_metodo,
        Long cantidad_m
){
}
