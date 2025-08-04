package com.bcss.shopall.service;

import com.bcss.shopall.domain.Inventario;
import com.bcss.shopall.domain.Tienda;
import com.bcss.shopall.repository.TiendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TiendaServiceImpl implements TiendaService {

    private final TiendaRepository tiendaRepository;
    private final InventarioService inventarioService;

    public TiendaServiceImpl(TiendaRepository tiendaRepository, InventarioService inventarioService) {
        this.tiendaRepository = tiendaRepository;
        this.inventarioService = inventarioService;
    }

    @Override
    public Tienda crearTienda(Tienda tienda) {
        Inventario inventario = inventarioService.crearInventario(tienda.getInventario());
        tienda.setInventario(inventario);
        return tiendaRepository.save(tienda);
    }

    @Override
    public void eliminarTienda(Long id) {
        tiendaRepository.deleteById(id);
    }

    @Override
    public List<Tienda> listaPersonas() {
        return tiendaRepository.findAll();
    }

    @Override
    public Optional<Tienda> obtenerTiendaById(Long id) {
        return tiendaRepository.findById(id);
    }
}
