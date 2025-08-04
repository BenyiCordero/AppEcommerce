package com.bcss.shopall.service;

import com.bcss.shopall.domain.Carrito;

import java.util.List;
import java.util.Optional;

public interface CarritoService {

    Carrito crearCarrito(Carrito carrito);
    List<Carrito> listaCarrito();
    Optional<Carrito> buscarCarritoPorId(Long id);

}
