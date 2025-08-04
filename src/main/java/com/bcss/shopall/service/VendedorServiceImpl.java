package com.bcss.shopall.service;

import com.bcss.shopall.dto.Persona;
import com.bcss.shopall.dto.Vendedor;
import com.bcss.shopall.repository.VendedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendedorServiceImpl implements VendedorService {

    private final VendedorRepository vendedorRepository;
    private final PersonaService personaService;

    public VendedorServiceImpl(VendedorRepository vendedorRepository, PersonaService personaService) {
        this.vendedorRepository = vendedorRepository;
        this.personaService = personaService;
    }

    @Override
    public void crearVendedor(Vendedor vendedor) {
        Persona persona = personaService.crearPersona(vendedor.getPersona());
        vendedor.setPersona(persona);
        vendedorRepository.save(vendedor);
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
