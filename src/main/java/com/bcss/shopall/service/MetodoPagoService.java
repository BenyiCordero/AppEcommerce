package com.bcss.shopall.service;

import com.bcss.shopall.domain.MetodoPago;

import java.util.List;
import java.util.Optional;

public interface MetodoPagoService {

    MetodoPago crearMetodoPago(MetodoPago metodoPago);
    void actualizarMetodoPago(MetodoPago metodoPago);
    Optional<MetodoPago> buscarPorId(Long id);
    List<MetodoPago> listarMetodoPago();

}
