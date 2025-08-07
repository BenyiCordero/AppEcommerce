package com.bcss.shopall.service;

import com.bcss.shopall.domain.Inventario;
import com.bcss.shopall.domain.InventarioDetails;
import com.bcss.shopall.domain.Producto;
import com.bcss.shopall.dto.InventarioDetailsDTO;
import com.bcss.shopall.repository.InventarioDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioDetailsServiceImpl implements InventarioDetailsService {

    private final InventarioDetailsRepository inventarioDetailsRepository;
    private final ProductoService productoService;
    private final InventarioService inventarioService;

    public InventarioDetailsServiceImpl(InventarioDetailsRepository inventarioDetailsRepository, ProductoService productoService, InventarioService inventarioService, VentaDetailsService ventaDetailsService) {
        this.inventarioDetailsRepository = inventarioDetailsRepository;
        this.productoService = productoService;
        this.inventarioService = inventarioService;
    }

    @Override
    public InventarioDetails crearInventarioDetails(InventarioDetails inventarioDetails) {
        Optional<Inventario> inventario = inventarioService.buscarInventario(inventarioDetails.getInventario().getIdInventario());
        Optional<Producto> producto = productoService.buscarProductoPorId(inventarioDetails.getProducto().getIdProducto());
        inventarioDetails.setInventario(inventario.get());
        inventarioDetails.setProducto(producto.get());
        inventarioDetails.setCantidad(inventarioDetails.getCantidad());

        return  inventarioDetailsRepository.save(inventarioDetails);
    }

    @Override
    public Optional<InventarioDetails> findById(Long id) {
        return inventarioDetailsRepository.findById(id);
    }

    @Override
    public List<InventarioDetails> findByInventarioId(Long inventarioId) {
        return inventarioDetailsRepository.findByInventario(inventarioService.buscarInventario(inventarioId).get());
    }

    @Override
    public InventarioDetails findByProducto(Producto producto) {
        return inventarioDetailsRepository.findByProducto(producto).get();
    }

    @Override
    public InventarioDetails reducirInventario(InventarioDetailsDTO inventarioDetailsDTO) {
        Producto producto  = inventarioDetailsDTO.producto();
        InventarioDetails inventarioDetails =  inventarioDetailsRepository.findByProducto(producto).get();
        Integer cantidad = inventarioDetailsDTO.cantidad();
        Integer cantidadInventario = inventarioDetails.getCantidad();
        Integer cantidadFinal = cantidadInventario - cantidad;

        inventarioDetails.setCantidad(cantidadFinal);
        return inventarioDetailsRepository.save(inventarioDetails);
    }
}
