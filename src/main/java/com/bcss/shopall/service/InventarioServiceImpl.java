package com.bcss.shopall.service;

import com.bcss.shopall.domain.Inventario;
import com.bcss.shopall.repository.InventarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioServiceImpl implements InventarioService {

    private final InventarioRepository inventarioRepository;

    public InventarioServiceImpl(InventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }

    @Override
    public Inventario crearInventario(Inventario inventario) {
        return  inventarioRepository.save(inventario);
    }

    @Override
    public Inventario actualizarInventario(Inventario inventario) {
        return null;
    }

    @Override
    public void eliminarInventario(Long id) {
        inventarioRepository.deleteById(id);
    }

    @Override
    public Optional<Inventario> buscarInventario(Long id) {
        return inventarioRepository.findById(id);
    }

    @Override
    public List<Inventario> listarInventarios() {
        return inventarioRepository.findAll();
    }
}
