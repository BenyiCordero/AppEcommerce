package com.bcss.shopall.controller;

import com.bcss.shopall.auth.Rol;
import com.bcss.shopall.domain.Carrito;
import com.bcss.shopall.domain.Comprador;
import com.bcss.shopall.domain.Persona;
import com.bcss.shopall.dto.AuthRequestDTO;
import com.bcss.shopall.dto.CompradorDTO;
import com.bcss.shopall.dto.TokenResponse;
import com.bcss.shopall.exceptions.DatosNoValidosException;
import com.bcss.shopall.service.AuthService;
import com.bcss.shopall.service.CarritoService;
import com.bcss.shopall.service.CompradorService;
import com.bcss.shopall.service.PersonaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final PersonaService personaService;
    private final CarritoService carritoService;
    private final BCryptPasswordEncoder passwordEncoder; // asegúrate que lo tienes como @Bean

    public AuthController(AuthService authService, PersonaService personaService, CarritoService carritoService, CompradorService compradorService, PasswordEncoder passwordEncoder, BCryptPasswordEncoder passwordEncoder1) {
        this.authService = authService;
        this.personaService = personaService;
        this.carritoService = carritoService;
        this.passwordEncoder = passwordEncoder1;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody CompradorDTO compradorDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new DatosNoValidosException("Error de validacion" , bindingResult);
        }
        Comprador comprador = new Comprador();
        Persona persona = new Persona();
        Carrito carrito = new Carrito();

        persona.setNombre(compradorDTO.nombre());
        persona.setPrimerApellido(compradorDTO.primerApellido());
        persona.setSegundoApellido(compradorDTO.segundoApellido());
        persona.setDireccion(compradorDTO.direccion());
        persona.setEmail(compradorDTO.email());
        persona.setPassword(passwordEncoder.encode(compradorDTO.password()));
        persona.setRol(Rol.COMPRADOR);
        personaService.crearPersona(persona);

        carritoService.crearCarrito(carrito);

        comprador.setPersona(persona);
        comprador.setCarrito(carrito);
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.crearComprador(comprador));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> authenticate(@RequestBody AuthRequestDTO request) {
        final TokenResponse response = authService.authenticate(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/refresh-token")
    public TokenResponse refreshToken(
            @RequestHeader(HttpHeaders.AUTHORIZATION) final String authentication
    ) {
        return authService.refreshToken(authentication);
    }

}
