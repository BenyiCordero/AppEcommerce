package com.bcss.shopall.service;

import com.bcss.shopall.domain.Persona;
import com.bcss.shopall.repository.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }


    @Override
    public Persona crearPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public void actualizarPersona(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public List<Persona> listaPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public Optional<Persona> buscarPersonaById(Long id) {
        return personaRepository.findById(id);
    }
}
