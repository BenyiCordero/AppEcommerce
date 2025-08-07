package com.bcss.shopall.service;

import com.bcss.shopall.domain.Carrito;
import com.bcss.shopall.repository.CarritoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoServiceImpl implements CarritoService {

    private final CarritoRepository carritoRepository;

    public CarritoServiceImpl(CarritoRepository carritoRepository) {
        this.carritoRepository = carritoRepository;
    }

    @Transactional
    public Carrito crearCarrito(Carrito carrito) {
        return carritoRepository.save(carrito);
    }

    @Override
    public List<Carrito> listaCarrito() {
        return carritoRepository.findAll();
    }

    @Override
    public Optional<Carrito> buscarCarritoPorId(Long id) {
        return carritoRepository.findById(id);
    }
}
