package com.bcss.shopall.service;

import com.bcss.shopall.domain.*;
import com.bcss.shopall.dto.InventarioDetailsDTO;
import com.bcss.shopall.repository.VentaDetailsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaDetailsServiceImpl implements VentaDetailsService {

    private final VentaDetailsRepository ventaDetailsRepository;
    private final VentaService ventaService;
    private final ProductoService productoService;
    private final InventarioDetailsService inventarioDetailsService;
    private final MetodoPagoDetailsService metodoPagoDetailsService;

    public VentaDetailsServiceImpl(VentaDetailsRepository ventaDetailsRepository, VentaService ventaService, ProductoService productoService, InventarioService inventarioService, InventarioDetailsService inventarioDetailsService, MetodoPagoDetailsService metodoPagoDetailsService, MetodoPagoService metodoPagoService) {
        this.ventaDetailsRepository = ventaDetailsRepository;
        this.ventaService = ventaService;
        this.productoService = productoService;
        this.inventarioDetailsService = inventarioDetailsService;
        this.metodoPagoDetailsService = metodoPagoDetailsService;
    }

    @Transactional
    public VentaDetails crearVentaDetails(VentaDetails ventaDetails, MetodoPagoDetails metodoPagoDetails) {
        Optional<Producto> producto = productoService.buscarProductoPorId(ventaDetails.getProducto().getIdProducto());
        Optional<Venta> venta = ventaService.buscarPorId(ventaDetails.getVenta().getIdVenta());
        ventaDetails.setProducto(producto.get());
        ventaDetails.setVenta(venta.get());
        ventaDetails.setCantidad(ventaDetails.getCantidad());
        ventaDetails.setTotal(ventaDetails.getTotal());

        InventarioDetailsDTO inventarioDetailsDTO = new InventarioDetailsDTO(producto.get(), ventaDetails.getCantidad());

        MetodoPagoDetails metodoPagoDetails1 = new MetodoPagoDetails();
        metodoPagoDetails1.setVenta(venta.get());
        metodoPagoDetails1.setMetodoPago(metodoPagoDetails.getMetodoPago());
        metodoPagoDetails1.setCantidad(metodoPagoDetails.getCantidad());

        metodoPagoDetailsService.crearMetodoPagoDetails(metodoPagoDetails1);
        inventarioDetailsService.reducirInventario(inventarioDetailsDTO);

        return ventaDetailsRepository.save(ventaDetails);
    }

    @Override
    public List<VentaDetails> findByVenta(Long idVenta) {
        return ventaDetailsRepository.findByVenta(ventaService.buscarPorId(idVenta).get());
    }
}
