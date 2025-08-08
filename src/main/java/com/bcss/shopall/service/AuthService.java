package com.bcss.shopall.service;

import com.bcss.shopall.domain.Comprador;
import com.bcss.shopall.domain.Persona;
import com.bcss.shopall.dto.AuthRequestDTO;
import com.bcss.shopall.dto.TokenResponse;
import jakarta.validation.constraints.NotNull;

public interface AuthService {
    TokenResponse authenticate(final AuthRequestDTO request);
    void saveUserToken(Persona empleado, String jwtToken);
    void revokeAllUserTokens(final Persona empleado);
    TokenResponse refreshToken(@NotNull final String authentication);
    Comprador crearComprador(Comprador comprador);

}
