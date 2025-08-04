package com.bcss.shopall.service;

import com.bcss.shopall.domain.Venta;

import java.util.List;
import java.util.Optional;

public interface VentaService {

    Venta crearVenta(Venta venta);
    Optional<Venta> buscarPorId(Long id);
    List<Venta> listaVentas();

}
