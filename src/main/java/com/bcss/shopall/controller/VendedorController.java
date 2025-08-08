package com.bcss.shopall.controller;

import com.bcss.shopall.auth.Rol;
import com.bcss.shopall.domain.Inventario;
import com.bcss.shopall.domain.Persona;
import com.bcss.shopall.domain.Tienda;
import com.bcss.shopall.domain.Vendedor;
import com.bcss.shopall.dto.VendedorDTO;
import com.bcss.shopall.exceptions.DatosNoValidosException;
import com.bcss.shopall.service.InventarioService;
import com.bcss.shopall.service.PersonaService;
import com.bcss.shopall.service.TiendaService;
import com.bcss.shopall.service.VendedorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {

    private final VendedorService vendedorService;
    private final PersonaService personaService;
    private final TiendaService tiendaService;
    private final InventarioService inventarioService;

    public VendedorController(VendedorService vendedorService, PersonaService personaService, TiendaService tiendaService, InventarioService inventarioService) {
        this.vendedorService = vendedorService;
        this.personaService = personaService;
        this.tiendaService = tiendaService;
        this.inventarioService = inventarioService;
    }

    @PostMapping
    public ResponseEntity<?> crearVendedor(@Valid @RequestBody VendedorDTO vendedorDTO, BindingResult  bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new DatosNoValidosException("Error de validacion" , bindingResult);
        }
        Vendedor vendedor = new Vendedor();
        Persona  persona = new Persona();
        Tienda tienda = new Tienda();
        Inventario inventario = new Inventario();

        persona.setNombre(vendedorDTO.nombre());
        persona.setPrimerApellido(vendedorDTO.primerApellido());
        persona.setSegundoApellido(vendedorDTO.segundoApellido());
        persona.setDireccion(vendedorDTO.direccion());
        persona.setEmail(vendedorDTO.email());
        persona.setPassword(vendedorDTO.password());
        persona.setRol(Rol.VENDEDOR);
        personaService.crearPersona(persona);

        tienda.setNombre(vendedorDTO.nombreTienda());
        inventarioService.crearInventario(inventario);
        tienda.setInventario(inventario);
        tiendaService.crearTienda(tienda);

        vendedor.setPersona(persona);
        vendedor.setTienda(tienda);

        return ResponseEntity.status(HttpStatus.CREATED).body(vendedorService.crearVendedor(vendedor));
    }

    @GetMapping
    public ResponseEntity<?> listaVendedores() {
        return ResponseEntity.status(HttpStatus.OK).body(vendedorService.listaVendedores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarVendedorPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(vendedorService.buscarVendedorPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarVendedor(@PathVariable Long id) {
        vendedorService.eliminarVendedor(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    //@PutMapping

}
