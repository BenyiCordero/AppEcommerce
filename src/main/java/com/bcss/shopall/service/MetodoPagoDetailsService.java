package com.bcss.shopall.service;

import com.bcss.shopall.domain.MetodoPagoDetails;

import java.util.List;

public interface MetodoPagoDetailsService {

    MetodoPagoDetails crearMetodoPagoDetails(MetodoPagoDetails metodoPagoDetails);
    List<MetodoPagoDetails> buscarMetodoPagoDetailsPorVenta(Long idVenta);

}
