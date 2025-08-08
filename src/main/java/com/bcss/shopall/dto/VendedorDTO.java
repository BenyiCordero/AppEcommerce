package com.bcss.shopall.dto;

import jakarta.validation.constraints.NotBlank;

public record VendedorDTO (
        @NotBlank(message = "El nombre no puede estar en blanco")
        String nombre,
        @NotBlank(message = "El primer apellido no puede estar en blanco")
        String primerApellido,
        String segundoApellido,
        @NotBlank(message = "La direccion no puede estar en blanco")
        String direccion,
        @NotBlank(message = "El nombre de la tienda no puede estar en blanco")
        String nombreTienda
){
}
