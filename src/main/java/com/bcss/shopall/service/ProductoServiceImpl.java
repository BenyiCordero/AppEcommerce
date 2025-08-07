package com.bcss.shopall.service;

import com.bcss.shopall.domain.Producto;
import com.bcss.shopall.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Transactional
    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Transactional
    public void ActualizarProducto(Producto producto) {

    }

    @Override
    public Optional<Producto> buscarProductoPorId(Long id) {
        return  productoRepository.findById(id);
    }

    @Override
    public List<Producto> listaProductos() {
        return productoRepository.findAll();
    }
}
