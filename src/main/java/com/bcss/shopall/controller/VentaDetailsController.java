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
    private final MetodoPagoService metodoPagoService;

    public VentaDetailsController(VentaService ventaService, ProductoService productoService, InventarioService inventarioService, InventarioDetailsService productoDetailsService, VentaDetailsService ventaDetailsService, MetodoPagoService metodoPagoService) {
        this.ventaService = ventaService;
        this.productoService = productoService;
        this.productoDetailsService = productoDetailsService;
        this.ventaDetailsService = ventaDetailsService;
        this.metodoPagoService = metodoPagoService;
    }

    @PostMapping
    public ResponseEntity<?> crearVentaDetails(@RequestBody VentaDTO ventaDTO) {
        Producto producto = productoService.buscarProductoPorId(ventaDTO.id_producto()).get();
        Double precioUnitario = productoDetailsService.findByProducto(producto).getPrecio();
        Venta venta = new Venta();
        VentaDetails ventaDetails = new VentaDetails();
        MetodoPagoDetails metodoPagoDetails = new MetodoPagoDetails();

        ventaService.crearVenta(venta);
        ventaDetails.setProducto(producto);
        ventaDetails.setCantidad(ventaDTO.cantidad());
        ventaDetails.setVenta(venta);
        ventaDetails.setTotal(ventaDTO.cantidad() * precioUnitario);
        metodoPagoDetails.setCantidad(ventaDTO.cantidad_m().doubleValue());
        metodoPagoDetails.setVenta(venta);
        metodoPagoDetails.setMetodoPago(metodoPagoService.buscarPorId(ventaDTO.id_metodo()).get());

        return ResponseEntity.status(HttpStatus.CREATED).body(ventaDetailsService.crearVentaDetails(ventaDetails, metodoPagoDetails));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarVenta(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(productoDetailsService.findByInventarioId(id));
    }

}
