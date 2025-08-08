package com.bcss.shopall.service;

import com.bcss.shopall.domain.Persona;

import javax.crypto.SecretKey;
import java.util.Date;

public interface JwtService {

    String extractUsername(String token);

    String generateToken(final Persona persona); // Cambiado a UserDetails

    String generateRefreshToken(final Persona persona); // Cambiado a UserDetails

    String buildToken(final Persona persona, final long expiration); // Cambiado a UserDetails

    boolean isTokenValid(String token, Persona persona); // Cambiado a UserDetails

    boolean isTokenExpired(String token);

    Date extractExpiration(String token);

    SecretKey getSignInKey();
}
