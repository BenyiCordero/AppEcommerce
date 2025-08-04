package com.bcss.shopall.service;

import com.bcss.shopall.domain.CarritoDetails;
import com.bcss.shopall.domain.Producto;
import com.bcss.shopall.repository.CarritoDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarritoDetailsServiceImpl implements CarritoDetailsService {

    private final CarritoDetailsRepository carritoDetailsRepository;
    private final ProductoService productoService;

    public CarritoDetailsServiceImpl(CarritoDetailsRepository carritoDetailsRepository, ProductoService productoService) {
        this.carritoDetailsRepository = carritoDetailsRepository;
        this.productoService = productoService;
    }

    @Override
    public CarritoDetails crearCarritoDetails(CarritoDetails carritoDetails) {
        Optional<Producto> producto = productoService.buscarProductoPorId(carritoDetails.getProducto().getIdProducto());
        carritoDetails.setProducto(producto.get());
        return carritoDetailsRepository.save(carritoDetails);
    }

    @Override
    public Optional<CarritoDetails> buscarPorId(Long id) {
        return carritoDetailsRepository.findById(id);
    }

    @Override
    public Optional<CarritoDetails> buscarPorCarrito(Long idCarrito) {
        return Optional.empty();
    }
}
