package com.bcss.shopall.service;

import com.bcss.shopall.domain.CarritoDetails;

import java.util.List;
import java.util.Optional;

public interface CarritoDetailsService {

    CarritoDetails crearCarritoDetails(CarritoDetails carritoDetails);
    Optional<CarritoDetails> buscarPorId(Long id);
    List<CarritoDetails> buscarPorCarrito(Long idCarrito);
    List<CarritoDetails> buscarPorComprador(Long idComprador);
}
