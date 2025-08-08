package com.bcss.shopall.service;

import com.bcss.shopall.domain.Carrito;
import com.bcss.shopall.domain.Comprador;
import com.bcss.shopall.domain.Persona;
import com.bcss.shopall.domain.Token;
import com.bcss.shopall.dto.AuthRequestDTO;
import com.bcss.shopall.dto.TokenResponse;
import com.bcss.shopall.repository.CompradorRepository;
import com.bcss.shopall.repository.TokenRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    private final PasswordEncoder passwordEncoder;
    private final TokenRepository tokenRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PersonaService personaService;
    private final CarritoService carritoService;
    private final CompradorRepository compradorRepository;

    public AuthServiceImpl(PasswordEncoder passwordEncoder, TokenRepository tokenRepository, JwtService jwtService, AuthenticationManager authenticationManager, PersonaService personaService, CarritoService carritoService, CompradorService compradorService, CompradorRepository compradorRepository) {
        this.passwordEncoder = passwordEncoder;
        this.tokenRepository = tokenRepository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.personaService = personaService;
        this.carritoService = carritoService;
        this.compradorRepository = compradorRepository;
    }

    @Override
    public TokenResponse authenticate(AuthRequestDTO request) {
        System.out.println("Attempting login with email: " + request.email() + ", password: " + request.password());
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.email(),
                            request.password()
                    )
            );
        } catch (AuthenticationException e) {
            System.out.println("Authentication failed:");
            e.printStackTrace();
            throw e;
        }
        final Persona adminUser = personaService.findByEmail(request.email())
                .orElseThrow();
        final String accessToken = jwtService.generateToken(adminUser);
        final String refreshToken = jwtService.generateRefreshToken(adminUser);
        revokeAllUserTokens(adminUser);
        saveUserToken(adminUser, accessToken);
        return new TokenResponse(accessToken, refreshToken);
    }

    @Override
    public void saveUserToken(Persona empleado, String jwtToken) {
        final Token token = Token.builder()
                .persona(empleado)
                .token(jwtToken)
                .tokenType(Token.TokenType.BEARER)
                .isExpired(false)
                .isRevoked(false)
                .build();
        tokenRepository.save(token);
    }

    @Override
    public void revokeAllUserTokens(Persona empleado) {
        // Encuentra TODOS los tokens de ese usuario, activos o inactivos.
        // Esto es más seguro para evitar duplicados si un token "viejo" que no era "valid" causó el problema.
        final List<Token> allUserTokens = tokenRepository.findByPersona(empleado); // Necesitarías este método en tu TokenRepository

        if (!allUserTokens.isEmpty()) {
            tokenRepository.deleteAll(allUserTokens); // <-- Elimina todos los tokens anteriores del usuario
        }
    }

    @Override
    public TokenResponse refreshToken(String authentication) {
        if (authentication == null || !authentication.startsWith("Bearer ")) {
            throw new IllegalArgumentException("Invalid auth header");
        }
        final String refreshToken = authentication.substring(7);
        final String userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail == null) {
            return null;
        }

        final Persona adminUser = this.personaService.findByEmail(userEmail).orElseThrow();
        final boolean isTokenValid = jwtService.isTokenValid(refreshToken, adminUser);
        if (!isTokenValid) {
            return null;
        }

        final String accessToken = jwtService.generateRefreshToken(adminUser);
        revokeAllUserTokens(adminUser);
        saveUserToken(adminUser, accessToken);

        return new TokenResponse(accessToken, refreshToken);
    }

    @Override
    public Comprador crearComprador(Comprador comprador) {
        Persona persona = personaService.crearPersona(comprador.getPersona());
        Carrito carrito = carritoService.crearCarrito(comprador.getCarrito());
        comprador.setCarrito(carrito);
        comprador.setPersona(persona);
        return compradorRepository.save(comprador);
    }
}
