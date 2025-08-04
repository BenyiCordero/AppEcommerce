package com.bcss.shopall.service;

import com.bcss.shopall.domain.Producto;
import com.bcss.shopall.domain.Venta;
import com.bcss.shopall.domain.VentaDetails;
import com.bcss.shopall.repository.VentaDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaDetailsServiceImpl implements VentaDetailsService {

    private final VentaDetailsRepository ventaDetailsRepository;
    private final VentaService ventaService;
    private final ProductoService productoService;

    public VentaDetailsServiceImpl(VentaDetailsRepository ventaDetailsRepository, VentaService ventaService, ProductoService productoService) {
        this.ventaDetailsRepository = ventaDetailsRepository;
        this.ventaService = ventaService;
        this.productoService = productoService;
    }

    @Override
    public VentaDetails crearVentaDetails(VentaDetails ventaDetails) {
        Optional<Producto> producto = productoService.buscarProductoPorId(ventaDetails.getProducto().getIdProducto());
        Optional<Venta> venta = ventaService.buscarPorId(ventaDetails.getVenta().getIdVenta());
        ventaDetails.setProducto(producto.get());
        ventaDetails.setVenta(venta.get());
        return ventaDetailsRepository.save(ventaDetails);
    }

    @Override
    public List<VentaDetails> findByVenta(Long idVenta) {
        return ventaDetailsRepository.findByVenta(ventaService.buscarPorId(idVenta).get());
    }
}
