package com.bcss.shopall.service;

import com.bcss.shopall.domain.Comprador;
import com.bcss.shopall.domain.Persona;
import com.bcss.shopall.repository.CompradorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompradorServiceImpl implements CompradorService {

    private final CompradorRepository compradorRepository;
    private final PersonaService personaService;

    public CompradorServiceImpl(CompradorRepository compradorRepository, PersonaService personaService) {
        this.compradorRepository = compradorRepository;
        this.personaService = personaService;
    }

    @Override
    public void crearComprador(Comprador comprador) {
        Persona persona = personaService.crearPersona(comprador.getPersona());
        comprador.setPersona(persona);
        compradorRepository.save(comprador);
    }

    @Override
    public void actualizarComprador(Comprador comprador) {

    }

    @Override
    public void eliminarComprador(Long id) {
        Optional<Comprador> comprador = compradorRepository.findById(id);
        comprador.ifPresent(compradorRepository::delete);
    }

    @Override
    public List<Comprador> listaCompradores() {
        return compradorRepository.findAll();
    }

    @Override
    public Optional<Comprador> buscarCompradorPorId(Long id) {
        return compradorRepository.findById(id);
    }
}
