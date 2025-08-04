package com.bcss.shopall.service;

import com.bcss.shopall.domain.Inventario;

import java.util.List;
import java.util.Optional;

public interface InventarioService {

    Inventario crearInventario(Inventario inventario);
    Inventario actualizarInventario(Inventario inventario);
    void eliminarInventario(Long id);
    Optional<Inventario> buscarInventario(Long id);
    List<Inventario> listarInventarios();

}
