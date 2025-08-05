package com.bcss.shopall.service;

import com.bcss.shopall.domain.Inventario;
import com.bcss.shopall.domain.ProductoDetails;
import com.bcss.shopall.domain.Producto;
import com.bcss.shopall.repository.ProductoDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoDetailsServiceImpl implements ProductoDetailsService {

    private final ProductoDetailsRepository productoDetailsRepository;
    private final ProductoService productoService;
    private final InventarioService inventarioService;

    public ProductoDetailsServiceImpl(ProductoDetailsRepository productoDetailsRepository, ProductoService productoService, InventarioService inventarioService) {
        this.productoDetailsRepository = productoDetailsRepository;
        this.productoService = productoService;
        this.inventarioService = inventarioService;
    }

    @Override
    public ProductoDetails crearInventarioDetails(ProductoDetails productoDetails) {
        Optional<Inventario> inventario = inventarioService.buscarInventario(productoDetails.getInventario().getIdInventario());
        Optional<Producto> producto = productoService.buscarProductoPorId(productoDetails.getProducto().getIdProducto());
        productoDetails.setInventario(inventario.get());
        productoDetails.setProducto(producto.get());
        return  productoDetailsRepository.save(productoDetails);
    }

    @Override
    public Optional<ProductoDetails> findById(Long id) {
        return productoDetailsRepository.findById(id);
    }

    @Override
    public List<ProductoDetails> findByInventarioId(Long inventarioId) {
        return productoDetailsRepository.findByInventario(inventarioService.buscarInventario(inventarioId).get());
    }
}
