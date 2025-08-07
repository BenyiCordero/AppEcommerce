package com.bcss.shopall.service;


import com.bcss.shopall.domain.MetodoPago;
import com.bcss.shopall.domain.MetodoPagoDetails;
import com.bcss.shopall.domain.Venta;
import com.bcss.shopall.repository.MetodoPagoDetailsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetodoPagoDetailsServiceImpl implements MetodoPagoDetailsService {

    private final MetodoPagoDetailsRepository metodoPagoDetailsRepository;
    private final VentaService ventaService;
    private final MetodoPagoService metodoPagoService;

    public MetodoPagoDetailsServiceImpl(MetodoPagoDetailsRepository metodoPagoDetailsRepository, ProductoService productoService, VentaService ventaService, MetodoPagoService metodoPagoService) {
        this.metodoPagoDetailsRepository = metodoPagoDetailsRepository;
        this.ventaService = ventaService;
        this.metodoPagoService = metodoPagoService;
    }

    @Transactional
    public MetodoPagoDetails crearMetodoPagoDetails(MetodoPagoDetails metodoPagoDetails) {
        Optional<MetodoPago> metodoPago = metodoPagoService.buscarPorId(metodoPagoDetails.getMetodoPago().getIdMetodoPago());
        Optional<Venta> venta = ventaService.buscarPorId(metodoPagoDetails.getVenta().getIdVenta());
        metodoPagoDetails.setMetodoPago(metodoPago.get());
        metodoPagoDetails.setVenta(venta.get());
        return metodoPagoDetailsRepository.save(metodoPagoDetails);
    }

    @Override
    public List<MetodoPagoDetails> buscarMetodoPagoDetailsPorVenta(Long idVenta) {
        return metodoPagoDetailsRepository.findByVenta(ventaService.buscarPorId(idVenta).get());
    }
}
