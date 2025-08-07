package com.bcss.shopall.controller;

import com.bcss.shopall.domain.*;
import com.bcss.shopall.dto.VentaDTO;
import com.bcss.shopall.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/venta")
public class VentaDetailsController {

    private final VentaService ventaService;
    private final ProductoService productoService;
    private final InventarioDetailsService productoDetailsService;
    private final VentaDetailsService ventaDetailsService;

    public VentaDetailsController(VentaService ventaService, ProductoService productoService, InventarioService inventarioService, InventarioDetailsService productoDetailsService, VentaDetailsService ventaDetailsService) {
        this.ventaService = ventaService;
        this.productoService = productoService;
        this.productoDetailsService = productoDetailsService;
        this.ventaDetailsService = ventaDetailsService;
    }

    @PostMapping
    public ResponseEntity<?> crearVentaDetails(@RequestBody VentaDTO ventaDTO) {
        Producto producto = productoService.buscarProductoPorId(ventaDTO.id_producto()).get();
        Venta venta = new Venta();
        VentaDetails ventaDetails = new VentaDetails();

        ventaService.crearVenta(venta);
        ventaDetails.setProducto(producto);
        ventaDetails.setCantidad(ventaDTO.cantidad());
        ventaDetails.setVenta(venta);

        return ResponseEntity.status(HttpStatus.CREATED).body(ventaDetailsService.crearVentaDetails(ventaDetails));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarVenta(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(productoDetailsService.findByInventarioId(id));
    }

}
