package com.bcss.shopall.service;

import com.bcss.shopall.domain.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    Producto crearProducto(Producto producto);
    void ActualizarProducto(Producto producto);
    Optional<Producto> buscarProductoPorId(Long id);
    List<Producto> listaProductos();

}
