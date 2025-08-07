package com.bcss.shopall.service;

import com.bcss.shopall.domain.MetodoPagoDetails;
import com.bcss.shopall.domain.Venta;
import com.bcss.shopall.domain.VentaDetails;

import java.util.List;

public interface VentaDetailsService {

    VentaDetails crearVentaDetails(VentaDetails ventaDetails, MetodoPagoDetails metodoPagoDetails);
    List<VentaDetails> findByVenta(Long idVenta);

}
