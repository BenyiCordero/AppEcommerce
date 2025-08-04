package com.bcss.shopall.service;

import com.bcss.shopall.domain.Carrito;
import com.bcss.shopall.domain.CarritoDetails;

import java.util.Optional;

public interface CarritoDetailsService {

    CarritoDetails crearCarritoDetails(CarritoDetails carritoDetails);
    Optional<CarritoDetails> buscarPorId(Long id);
    Optional<CarritoDetails> buscarPorCarrito(Long idCarrito);

}
