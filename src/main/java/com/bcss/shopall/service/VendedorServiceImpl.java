package com.bcss.shopall.service;

import com.bcss.shopall.domain.Persona;
import com.bcss.shopall.domain.Tienda;
import com.bcss.shopall.domain.Vendedor;
import com.bcss.shopall.repository.VendedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendedorServiceImpl implements VendedorService {

    private final VendedorRepository vendedorRepository;
    private final PersonaService personaService;
    private final TiendaService tiendaService;

    public VendedorServiceImpl(VendedorRepository vendedorRepository, PersonaService personaService, TiendaService tiendaService) {
        this.vendedorRepository = vendedorRepository;
        this.personaService = personaService;
        this.tiendaService = tiendaService;
    }

    @Override
    public Vendedor crearVendedor(Vendedor vendedor) {
        Persona persona = personaService.crearPersona(vendedor.getPersona());
        Tienda tienda = tiendaService.crearTienda(vendedor.getTienda());
        vendedor.setTienda(tienda);
        vendedor.setPersona(persona);
        return vendedorRepository.save(vendedor);
    }

    @Override
    public void actualizarVendedor(Vendedor vendedor) {

    }

    @Override
    public void eliminarVendedor(Long id) {
        Optional<Vendedor> vendedor = vendedorRepository.findById(id);
        vendedor.ifPresent(vendedorRepository::delete);
    }

    @Override
    public List<Vendedor> listaVendedores() {
        return vendedorRepository.findAll();
    }

    @Override
    public Optional<Vendedor> buscarVendedorPorId(Long id) {
        return vendedorRepository.findById(id);
    }
}
