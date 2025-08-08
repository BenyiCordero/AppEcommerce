package com.bcss.shopall.dto;

import jakarta.validation.constraints.Email;
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
        String nombreTienda,
        @NotBlank(message = "El email no puede estar en blanco")
        @Email(message = "El email tiene que tener una forma example@example.com")
        String email,
        @NotBlank(message = "El password no puede estar en blanco")
        String password
){
}
