package com.bcss.shopall.controller;

import com.bcss.shopall.domain.Carrito;
import com.bcss.shopall.domain.CarritoDetails;
import com.bcss.shopall.domain.Producto;
import com.bcss.shopall.dto.CarritoDetailsDTO;
import com.bcss.shopall.exceptions.DatosNoValidosException;
import com.bcss.shopall.service.CarritoDetailsService;
import com.bcss.shopall.service.CarritoService;
import com.bcss.shopall.service.CompradorService;
import com.bcss.shopall.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carritos")
public class CarritoDetailsController {

    private final CarritoDetailsService carritoDetailsService;
    private final ProductoService productoService;
    private final CarritoService carritoService;

    public CarritoDetailsController(CarritoDetailsService carritoDetailsService, ProductoService productoService, CarritoService carritoService, CompradorService compradorService) {
        this.carritoDetailsService = carritoDetailsService;
        this.productoService = productoService;
        this.carritoService = carritoService;
    }

    @PostMapping
    public ResponseEntity<?> aniadirProducto(@Valid @RequestBody CarritoDetailsDTO carritoDetailsDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new DatosNoValidosException("Error de validacion" , bindingResult);
        }

        Carrito carrito = carritoService.buscarCarritoPorId(carritoDetailsDTO.idCarrito()).get();
        Producto producto = productoService.buscarProductoPorId(carritoDetailsDTO.idProducto()).get();
        CarritoDetails carritoDetails = new CarritoDetails();

        carritoDetails.setProducto(producto);
        carritoDetails.setCarrito(carrito);
        carritoDetails.setCantidad(carritoDetailsDTO.cantidad());

        return ResponseEntity.status(HttpStatus.CREATED).body(carritoDetailsService.crearCarritoDetails(carritoDetails));

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCarritoDetailsByComprador(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(carritoDetailsService.buscarPorComprador(id));
    }

}
