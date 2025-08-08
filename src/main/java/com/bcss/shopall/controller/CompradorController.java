package com.bcss.shopall.controller;

import com.bcss.shopall.auth.Rol;
import com.bcss.shopall.domain.Carrito;
import com.bcss.shopall.domain.Comprador;
import com.bcss.shopall.domain.Persona;
import com.bcss.shopall.dto.CompradorDTO;
import com.bcss.shopall.exceptions.DatosNoValidosException;
import com.bcss.shopall.service.CarritoService;
import com.bcss.shopall.service.CompradorService;
import com.bcss.shopall.service.PersonaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;

@RestController
@RequestMapping("/compradores")
public class CompradorController {

    private final CompradorService compradorService;

    public CompradorController(CompradorService compradorService, PersonaService personaService, CarritoService carritoService) {
        this.compradorService = compradorService;
    }

    @GetMapping
    public ResponseEntity<?> listaCompradores() {
        return ResponseEntity.status(HttpStatus.OK).body(compradorService.listaCompradores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> compradorPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(compradorService.buscarCompradorPorId(id));
    }

}
