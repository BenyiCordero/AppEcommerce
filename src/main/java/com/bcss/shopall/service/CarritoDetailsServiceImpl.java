package com.bcss.shopall.service;

import com.bcss.shopall.domain.CarritoDetails;
import com.bcss.shopall.domain.Producto;
import com.bcss.shopall.repository.CarritoDetailsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoDetailsServiceImpl implements CarritoDetailsService {

    private final CarritoDetailsRepository carritoDetailsRepository;
    private final CarritoService carritoService;

    public CarritoDetailsServiceImpl(CarritoDetailsRepository carritoDetailsRepository, ProductoService productoService, CarritoService carritoService) {
        this.carritoDetailsRepository = carritoDetailsRepository;
        this.carritoService = carritoService;
    }

    @Transactional
    public CarritoDetails crearCarritoDetails(CarritoDetails carritoDetails) {
        return carritoDetailsRepository.save(carritoDetails);
    }

    @Override
    public Optional<CarritoDetails> buscarPorId(Long id) {
        return carritoDetailsRepository.findById(id);
    }

    @Override
    public List<CarritoDetails> buscarPorCarrito(Long idCarrito) {
        return carritoDetailsRepository.findByCarrito(carritoService.buscarCarritoPorId(idCarrito).get());
    }

    @Override
    public List<CarritoDetails> buscarPorComprador(Long idComprador) {
        return carritoDetailsRepository.findByComprador(idComprador);
    }
}
