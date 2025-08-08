package com.bcss.shopall.dto;

import com.bcss.shopall.auth.Rol;
import com.bcss.shopall.domain.Persona;

public record PersonaResponseDTO(
        Rol rol,
        Persona persona
) {
}
