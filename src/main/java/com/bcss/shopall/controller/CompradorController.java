package com.bcss.shopall.controller;

import com.bcss.shopall.domain.Carrito;
import com.bcss.shopall.domain.Comprador;
import com.bcss.shopall.domain.Persona;
import com.bcss.shopall.dto.CompradorDTO;
import com.bcss.shopall.service.CarritoService;
import com.bcss.shopall.service.CompradorService;
import com.bcss.shopall.service.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comprador")
public class CompradorController {

    private final CompradorService compradorService;
    private final PersonaService personaService;
    private final CarritoService carritoService;

    public CompradorController(CompradorService compradorService, PersonaService personaService, CarritoService carritoService) {
        this.compradorService = compradorService;
        this.personaService = personaService;
        this.carritoService = carritoService;
    }

    @PostMapping
    public ResponseEntity<?> crearComprador(@RequestBody CompradorDTO compradorDTO) {
        Comprador comprador = new Comprador();
        Persona persona = new Persona();
        Carrito carrito = new Carrito();

        persona.setNombre(compradorDTO.nombre());
        persona.setPrimerApellido(compradorDTO.primerApellido());
        persona.setSegundoApellido(compradorDTO.segundoApellido());
        persona.setDireccion(compradorDTO.direccion());
        personaService.crearPersona(persona);

        carritoService.crearCarrito(carrito);

        comprador.setPersona(persona);
        comprador.setCarrito(carrito);
        return ResponseEntity.status(HttpStatus.CREATED).body(compradorService.crearComprador(comprador));
    }

    @GetMapping
    public ResponseEntity<?> listaCompradores() {
        return ResponseEntity.status(HttpStatus.OK).body(compradorService.listaCompradores());
    }

    @GetMapping
    public ResponseEntity<?> compradorPorId(Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(compradorService.buscarCompradorPorId(id));
    }

}
